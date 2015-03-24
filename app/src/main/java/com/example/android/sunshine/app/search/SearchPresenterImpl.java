package com.example.android.sunshine.app.search;

import android.app.Activity;
import android.os.Bundle;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/24/15.
 */
public class SearchPresenterImpl implements SearchPresenter {
    private final SearchModel model;
    private final SearchView view;
    private Subscription subscription;

    public SearchPresenterImpl(SearchModel model, SearchView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        /*subscription = model.changeCity()
                .debounce(150, TimeUnit.MILLISECONDS)
                .switchMap(model::request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showWeather);*/

        subscription = model.changeCity()
                .switchMap(model::request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showWeather);
    }

    @Override
    public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
