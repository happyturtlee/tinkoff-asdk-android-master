package ru.tinkoff.acquiring.sample;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import ru.tinkoff.acquiring.sample.pages.BookPage;
import ru.tinkoff.acquiring.sample.pages.MainPage;
import ru.tinkoff.acquiring.sample.pages.PaymentPage;
import ru.tinkoff.acquiring.sample.pages.PaymentResultPage;
import ru.tinkoff.acquiring.sample.ui.MainActivity;

@RunWith(Parameterized.class)
@LargeTest
public class PaymentTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "The Monster", "4300 0000 0000 0777", "1220", "749" },
                { "The Secret Cabin", "5000 0000 0000 0777", "1220", "749" }
        });
    }
    @Parameter
    public String bookTitle;
    @Parameter(1)
    public String cardNumber;
    @Parameter(2)
    public String expirationDate;
    @Parameter(3)
    public String cvc;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Test
    public void runTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        BookPage bookPage = mainPage.chooseBookByTitle(bookTitle);
        PaymentPage paymentPage = bookPage.buyBook();
        PaymentResultPage paymentResultPage = paymentPage.pay(cardNumber, expirationDate, cvc);
        Assert.assertTrue("Payment failed", paymentResultPage.isSuccessfull());

    }
}

