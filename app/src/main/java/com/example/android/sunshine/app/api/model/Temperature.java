package com.example.android.sunshine.app.api.model;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/17/15.
 */
public class Temperature {
    private double max;
    private double min;

    public double getHighTemperature() {
        return max;
    }

    public double getLowTemperature() {
        return min;
    }
}
