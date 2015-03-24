package com.example.android.sunshine.app.search;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.sunshine.app.R;

public class SearchActivity extends ActionBarActivity {

    private SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        final SearchViewHolder searchViewHolder = new SearchViewHolder(
                (Spinner) findViewById(R.id.city_spinner),
                (TextView) findViewById(R.id.weather_text_view)
        );

        final SearchModel searchModel = new SearchModelImpl(searchViewHolder);
        final SearchView searchView = new SearchViewImpl(searchViewHolder);

        searchPresenter = new SearchPresenterImpl(searchModel, searchView);
        searchPresenter.onCreate(this, savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        searchPresenter.onDestroy();
    }
}
