package com.aditya.girnar.androidactivitydemo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;

import com.aditya.girnar.androidactivitydemo.Activities.FirstActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Aditya Sharma on 21/12/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IdlingResources {

    @Rule
    public ActivityTestRule<FirstActivity> mActivityRule =
            new ActivityTestRule<>(FirstActivity.class);

    MyIdleResource idlingResource;

    @Before
    public void setUp(){
        idlingResource = new MyIdleResource();
    }

    @Test
    public void testIdleResource(){
        onView(withId(R.id.btnNotify)).perform(click());

        IdlingPolicies.setMasterPolicyTimeout(
                5, TimeUnit.MINUTES);
        IdlingPolicies.setIdlingResourceTimeout(
                5, TimeUnit.MINUTES);

        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.done)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown(){
        Espresso.unregisterIdlingResources(idlingResource);
    }

    class MyIdleResource implements IdlingResource {
        private long startTime;
        ResourceCallback callback;
        MyIdleResource(){
            startTime = System.currentTimeMillis();
        }

        @Override
        public String getName() {
            return "MyIdleResource";
        }

        @Override
        public void registerIdleTransitionCallback(
                ResourceCallback resourceCallback) {
            this.callback = resourceCallback;
        }

        @Override
        public boolean isIdleNow() {
            boolean idle=false;
            if((startTime + 1000*10)<System.currentTimeMillis()){
                callback.onTransitionToIdle();
                idle=true;
            }
            return idle;
        }
    }
}

