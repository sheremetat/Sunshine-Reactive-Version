package com.example.android.sunshine.app.api;

import com.example.android.sunshine.app.api.model.City;
import com.example.android.sunshine.app.api.model.DayForecast;

import java.util.List;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/17/15.
 */
public class DailyForecast {
    private String code;
    private double message;
    private City city;
    private List<DayForecast> list;

    public City getCity() {
        return city;
    }

    public List<DayForecast> getDailyForecastList() {
        return list;
    }
}
