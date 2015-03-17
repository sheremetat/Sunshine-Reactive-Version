package com.example.android.sunshine.app.api.model;

import java.util.List;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/17/15.
 */
public class DayForecast {
    private long date;
    private Temperature temp;
    private double pressure;
    private int humidity;
    private double speed;
    private double deg;
    private List<Weather> weather;

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public Temperature getTemperature() {
        return temp;
    }

    public double getWindSpeed() {
        return speed;
    }

    public double getDirection() {
        return deg;
    }

    public long getDate() {
        return date;
    }

    public Weather getWeather() {
        if(weather != null)
            return weather.get(0);
        return null;
    }
}
