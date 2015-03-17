package com.example.android.sunshine.app.api;

import android.util.Log;

import retrofit.RestAdapter;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/17/15.
 */
public class RetrofitHelper {
    public static ForecastService getForecastService(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ForecastService.BASE_API_URL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.d("RetrofitHelper", message);
                    }
                })
                .build();

        return restAdapter.create(ForecastService.class);
    }
}
