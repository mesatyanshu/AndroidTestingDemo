package com.aditya.girnar.androidactivitydemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aditya on 1/19/2016.
 */
public class Utility {

    public static void wait2Seconds() {
        final CountDownLatch signal = new CountDownLatch(1);
        try {
            signal.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
