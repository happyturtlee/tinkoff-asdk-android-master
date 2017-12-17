package ru.tinkoff.acquiring.sample.pages;


import android.support.test.espresso.NoMatchingViewException;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public abstract class AbstractPage {
    static private long delay = 5L * 1000000000L;

    protected boolean checkStatus(Matcher viewMatcher, boolean throwE) {
        try {
            onView(viewMatcher).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException e) {
            if (throwE) throw e;
            else return false;
        }
    }

    protected void waitUntilLoaded(Matcher viewMatcher) throws NoMatchingViewException {
        long start = System.nanoTime();
        long end = start + delay;
        while (System.nanoTime() < end) {
            if (checkStatus(viewMatcher, false))
                return;
        }
        checkStatus(viewMatcher, true);
    }


}
