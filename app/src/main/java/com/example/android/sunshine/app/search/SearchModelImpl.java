package com.example.android.sunshine.app.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.android.sunshine.app.R;
import com.example.android.sunshine.app.Utility;
import com.example.android.sunshine.app.api.DailyForecast;
import com.example.android.sunshine.app.api.RetrofitHelper;
import com.example.android.sunshine.app.api.model.DayForecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.client.Response;
import retrofit.mime.TypedInput;
import rx.Observable;
import rx.android.view.ViewObservable;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/24/15.
 */
public class SearchModelImpl implements SearchModel {

    private final SearchViewHolder searchViewHolder;

    public SearchModelImpl(SearchViewHolder searchViewHolder) {
        this.searchViewHolder = searchViewHolder;
    }

    /*
    public Observable<String> changeQuery() {
        return WidgetObservable
                .text(searchViewHolder.editText)
                .map(new Func1<OnTextChangeEvent, String>() {
                    @Override
                    public String call(OnTextChangeEvent event) {
                        return event.toString().trim();
                    }
                });
    } */

    @Override
    public Observable<String> changeCity() {
        final PublishSubject<String> selectSubject = PublishSubject.create();
        searchViewHolder.citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                selectSubject.onNext(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return selectSubject;
    }

    @Override
    public Observable<String> request(String cityName) {
        return RetrofitHelper.getForecastService()
                .getAccurateByCityName(cityName, "json", "accurate")
                .doOnError(throwable -> Log.d("TTTTT", throwable.getLocalizedMessage()))
                .map(s -> {
                    TypedInput body = s.getBody();
                    StringBuilder out = new StringBuilder();
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(body.in()));
                        String newLine = System.getProperty("line.separator");
                        String line;
                        while ((line = reader.readLine()) != null) {
                            out.append(line);
                            out.append(newLine);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (!TextUtils.isEmpty(out.toString())) {
                        return out.toString();
                    } else {
                        return "No data found";
                    }
                });
    }
}
