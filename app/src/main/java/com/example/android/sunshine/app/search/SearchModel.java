package com.example.android.sunshine.app.search;

import rx.Observable;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/24/15.
 */
public interface SearchModel {
    Observable<String> changeCity();
    Observable<String> request(String cityName);
}
