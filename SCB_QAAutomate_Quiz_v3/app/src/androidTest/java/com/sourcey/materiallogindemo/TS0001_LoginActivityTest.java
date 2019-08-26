package com.sourcey.materiallogindemo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;

@RunWith(AndroidJUnit4.class)
public class TS0001_LoginActivityTest {

    public RegisterForLoginActivityTest registerForCreateData = new RegisterForLoginActivityTest();

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    //If log in success it will show ‘Material Login Example’ page.
    public void LoginSuccess_ShouldShowHelloworld() throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).check(matches(withText("Yukhonthorn.p@gmail.com")));
        onView(withId(R.id.input_password)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        sleep(3000);
        onView(withText("Hello world!")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
    }

    @Test
    //Email not existing in the system.
    public void LoginUnsuccess_ShouldShowHelloWorld() throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p1@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).check(matches(withText("Yukhonthorn.p1@gmail.com")));
        onView(withId(R.id.input_password)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("enter a valid email address"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    //Email is empty.
    public void EmailIsEmpty() throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).perform(clearText());
        onView(withId(R.id.input_password)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("enter a valid email address"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    //Password is empty.
    public void PasswordIsEmpty() throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).check(matches(withText("Yukhonthorn.p@gmail.com")));
        onView(withId(R.id.input_password)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(clearText());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("between 4 and 10 alphanumeric characters"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    //Email is a user login and it will check email format
    public void EmailInvalid() throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p"), closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("enter a valid email address"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    //Password: at least 4 character.
    public void PasswordTooShort()throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).check(matches(withText("Yukhonthorn.p@gmail.com")));
        onView(withId(R.id.input_password)).perform(typeText("P@s"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("between 4 and 10 alphanumeric characters"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    //Password: maximum is 10 character.
    public void PasswordTooLong() throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).check(matches(withText("Yukhonthorn.p@gmail.com")));
        onView(withId(R.id.input_password)).perform(typeText("P@ssword123456789"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("between 4 and 10 alphanumeric characters"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    //Logout Success them go to the login page.
    public void LogoutSuccess_ShouldShowLoginPage() throws InterruptedException{
        registerForCreateData.RegisterSuccess();
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).check(matches(withText("Yukhonthorn.p@gmail.com")));
        onView(withId(R.id.input_password)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        sleep(3000);
        onView(withText("Hello world!")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).perform(click());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }
}
