package com.example.android.sunshine.app.search;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/24/15.
 */
public class SearchViewImpl implements SearchView {

    private final SearchViewHolder searchViewHolder;

    public SearchViewImpl(SearchViewHolder searchViewHolder) {
        this.searchViewHolder = searchViewHolder;
    }

    @Override
    public void showWeather(String weatherString) {
        searchViewHolder.weatherTextView.setText(weatherString);
    }
}
