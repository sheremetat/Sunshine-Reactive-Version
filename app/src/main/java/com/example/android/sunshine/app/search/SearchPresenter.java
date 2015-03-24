package com.example.android.sunshine.app.search;

import android.app.Activity;
import android.os.Bundle;

/**
 * Sunshine-Version-2
 * Created by sheremetat on 3/24/15.
 */
public interface SearchPresenter {
    void onCreate(Activity activity, Bundle savedInstanceState);
    void onDestroy();
}
