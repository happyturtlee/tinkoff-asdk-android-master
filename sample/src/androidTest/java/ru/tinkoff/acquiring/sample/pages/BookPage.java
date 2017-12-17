package ru.tinkoff.acquiring.sample.pages;


import ru.tinkoff.acquiring.sample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class BookPage extends AbstractPage {
    private int buttonBuy = R.id.btn_buy_now;

    public PaymentPage buyBook() {
        onView(withId(buttonBuy)).perform(click());
        return new PaymentPage();

    }


}
