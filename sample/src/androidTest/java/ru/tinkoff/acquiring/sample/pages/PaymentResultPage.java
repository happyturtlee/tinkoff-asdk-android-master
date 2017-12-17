package ru.tinkoff.acquiring.sample.pages;


import ru.tinkoff.acquiring.sample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class PaymentResultPage extends AbstractPage{
    private int success = R.id.tv_confirm;

    public boolean isSuccessfull() {
        return checkStatus(withId(success), false);
    }


}
