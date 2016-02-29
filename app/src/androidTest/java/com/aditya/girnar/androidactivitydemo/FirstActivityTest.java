package com.aditya.girnar.androidactivitydemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.aditya.girnar.androidactivitydemo.Activities.FirstActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Aditya on 1/15/2016.
 */
@RunWith(AndroidJUnit4.class)
public class FirstActivityTest {

    @Rule
    public ActivityTestRule<FirstActivity> first = new ActivityTestRule<>(FirstActivity.class);

    @Test
    public void test1() {
        onView(withId(R.id.username)).perform(typeText("aditya"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("breakingba"), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());
    }

    @Test
    public void test2() {
        onView(withId(R.id.username)).perform(typeText("adiya"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("breakingbad"), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());
    }

    @Test
    public void test3() {
        onView(withId(R.id.username)).perform(typeText("aditya"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("breakingbad"), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());
        Utility.wait2Seconds();
    }
}

