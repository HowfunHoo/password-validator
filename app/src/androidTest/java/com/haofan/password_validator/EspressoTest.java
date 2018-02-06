package com.haofan.password_validator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Haofan on 2018-02-06.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    //Input a password which meets all rules
    public void inputStrongPassword(){
        onView(withId(R.id.et_passwd)).perform(typeText("Password_1"));
        onView(withId(R.id.btn_validate)).perform(click());

        onView(withId(R.id.tv_passwd_strength)).check(matches(withText("The password is strong!")));
    }

    @Test
    //Input a password which has less than 8 characters but meets all other rules
    public void inputNotLongEnoughPassword(){
        onView(withId(R.id.et_passwd)).perform(typeText("pasWd_1"));
        onView(withId(R.id.btn_validate)).perform(click());

        onView(withId(R.id.tv_passwd_strength)).check(matches(withText("The password is not strong!")));

    }

    @Test
    //Input a password which is 'Password' (Case insensitive) but meets all other rules
    public void inputNotPassword(){
        onView(withId(R.id.et_passwd)).perform(typeText("passWorD"));
        onView(withId(R.id.btn_validate)).perform(click());

        onView(withId(R.id.tv_passwd_strength)).check(matches(withText("The password is not strong!")));

    }

    @Test
    //Input a password which has no digit but meets all other rules
    public void inputNoDigitPassword(){
        onView(withId(R.id.et_passwd)).perform(typeText("passWord_"));
        onView(withId(R.id.btn_validate)).perform(click());

        onView(withId(R.id.tv_passwd_strength)).check(matches(withText("The password is not strong!")));

    }

    @Test
    //Input a password which has no upper characters but meets all other rules
    public void inputNoUpperCharPassword(){
        onView(withId(R.id.et_passwd)).perform(typeText("password_1"));
        onView(withId(R.id.btn_validate)).perform(click());

        onView(withId(R.id.tv_passwd_strength)).check(matches(withText("The password is not strong!")));

    }

    @Test
    //Input a password which has no lower characters but meets all other rules
    public void inputNoLowerCharPassword(){
        onView(withId(R.id.et_passwd)).perform(typeText("PASSWORD_1"));
        onView(withId(R.id.btn_validate)).perform(click());

        onView(withId(R.id.tv_passwd_strength)).check(matches(withText("The password is not strong!")));

    }

    @Test
    //Input a password which has no special characters but meets all other rules
    public void inputNoSpecialCharPassword(){
        onView(withId(R.id.et_passwd)).perform(typeText("passWord1"));
        onView(withId(R.id.btn_validate)).perform(click());

        onView(withId(R.id.tv_passwd_strength)).check(matches(withText("The password is not strong!")));

    }
}
