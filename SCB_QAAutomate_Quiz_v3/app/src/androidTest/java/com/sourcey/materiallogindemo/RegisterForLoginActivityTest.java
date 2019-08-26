package com.sourcey.materiallogindemo;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;

@RunWith(AndroidJUnit4.class)
public class RegisterForLoginActivityTest {

    @Test
    public void RegisterSuccess() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        onView(withId(R.id.input_name)).perform(typeText("Yukhonthorn Pinket"), closeSoftKeyboard());
        onView(withId(R.id.input_address)).perform(typeText("Sukhumvit77"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).perform(typeText("Yukhonthorn.p@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).check(matches(withText("Yukhonthorn.p@gmail.com")));
        onView(withId(R.id.input_mobile)).perform(typeText("0843581023"), closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.input_reEnterPassword)).perform(typeText("P@ssw0rd"), closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(click());
        sleep(3000);
        onView(withId(R.id.btn_logout)).perform(click());
    }
}
