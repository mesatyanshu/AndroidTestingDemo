package com.aditya.girnar.androidactivitydemo.Module;

import com.aditya.girnar.androidactivitydemo.Model.Motor;
import com.aditya.girnar.androidactivitydemo.Model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Satyanshu on 1/21/2016.
 */
@Module
public class VehicleModule {

//    @Provides
//    @Singleton
//    Motor provideMotor() {
//        return new Motor();
//    }

    @Provides
    @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Motor());
    }
}