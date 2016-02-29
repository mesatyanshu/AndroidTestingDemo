package com.aditya.girnar.androidactivitydemo.Module;

import com.aditya.girnar.androidactivitydemo.Model.Vehicle;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Satyanshu on 1/21/2016.
 */
@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
}
