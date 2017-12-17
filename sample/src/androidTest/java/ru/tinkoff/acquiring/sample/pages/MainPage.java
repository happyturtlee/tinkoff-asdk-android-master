package ru.tinkoff.acquiring.sample.pages;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

import ru.tinkoff.acquiring.sample.Book;
import ru.tinkoff.acquiring.sample.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

public class MainPage extends AbstractPage {
    private int booksList = R.id.lv_books;
    private int bookDetails = R.id.tv_book_details;

    public BookPage chooseBookBySeq(int bookSeq) {
        onData(anything()).inAdapterView(withId(booksList))
                .atPosition(bookSeq).onChildView(withId(bookDetails))
                .perform(click());
        return new BookPage();
    }

    public BookPage chooseBookByTitle(String bookTitle) {
        onData(withTitle(Matchers.equalTo(bookTitle)))
                .onChildView(withId(bookDetails)).perform(click());
        return new BookPage();
    }

    private static Matcher withTitle(final Matcher titleMatcher){
        return new TypeSafeMatcher<Book>(){
            @Override
            public void describeTo(Description description) {
                description.appendText("with title: ");
                titleMatcher.describeTo(description);
            }
            @Override
            public boolean matchesSafely(Book book) {
                return titleMatcher.matches(book.getTitle());
            }
        };
    }

}
