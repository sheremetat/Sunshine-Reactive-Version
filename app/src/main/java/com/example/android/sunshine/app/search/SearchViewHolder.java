package com.example.android.sunshine.app.search;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.sunshine.app.R;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/24/15.
 */
public class SearchViewHolder {
    public final Spinner citySpinner;
    public final TextView weatherTextView;

    public SearchViewHolder(Spinner citySpinner, TextView weatherTextView) {
        this.citySpinner = citySpinner;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(citySpinner.getContext(),
                R.array.city_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        this.weatherTextView = weatherTextView;
    }
}
