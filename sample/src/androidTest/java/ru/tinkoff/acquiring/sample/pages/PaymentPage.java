package ru.tinkoff.acquiring.sample.pages;


import org.hamcrest.Matchers;

import ru.tinkoff.acquiring.sample.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class PaymentPage extends AbstractPage{
    private int cvcHint = R.string.acq_cvc_hint;
    private int cardNumberHint = R.string.acq_card_number_hint;
    private int expirationDateHint = R.string.acq_exp_date_hint;
    private int payButton = R.id.btn_pay;

    public void enterCardData (String cardNumber, String expirationDate, String cvc) {
        onView(withHint(cardNumberHint)).perform(typeText(cardNumber));
        waitUntilLoaded(allOf(withHint(expirationDateHint), hasFocus()));
        onView(withHint(expirationDateHint)).perform(typeText(expirationDate));
        onView(withHint(cvcHint)).perform(typeText(cvc));
    }

    public void tapPayButton() {
        onView(withId(payButton)).perform(click());
    }

    public PaymentResultPage pay(String cardNumber, String expirationDate, String cvc) {
        enterCardData(cardNumber, expirationDate, cvc);
        tapPayButton();
        return new PaymentResultPage();

    }

}
