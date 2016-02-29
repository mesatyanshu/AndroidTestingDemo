package com.aditya.girnar.androidactivitydemo.Model;

import javax.inject.Inject;

/**
 * Created by Satyanshu on 1/21/2016.
 */
public class Vehicle {
    private Motor motor;

    @Inject
    public Vehicle(Motor motor) {
        this.motor = motor;
    }

    public void increaseSpeed(int value) {
        motor.accelerate(value);
    }

    public void stop() {
        motor.brake();
    }

    public int getSpeed() {
        return motor.getRpm();
    }
}
