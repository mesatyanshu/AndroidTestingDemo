package com.aditya.girnar.androidactivitydemo;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.aditya.girnar.androidactivitydemo.Activities.SecondActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Aditya on 1/15/2016.
 */
@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> first = new ActivityTestRule<>(SecondActivity.class);

    @Test
    public void test1() {
        onView(withId(R.id.recyclerView)).perform(swipeUp());
        Utility.wait2Seconds();
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(17, click()));
        Utility.wait2Seconds();
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(7, click()));
        Utility.wait2Seconds();
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(34, click()));
        Utility.wait2Seconds();
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        Utility.wait2Seconds();
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(23, click()));
        Utility.wait2Seconds();
    }
}
