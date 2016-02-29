package com.aditya.girnar.androidactivitydemo.Model;

/**
 * Created by Satyanshu on 1/21/2016.
 */
public class Motor {

    private int rpm;

    public Motor() {
        this.rpm = 10;
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int value) {
        rpm = rpm + value;
    }

    public void brake() {
        rpm = 0;
    }
}