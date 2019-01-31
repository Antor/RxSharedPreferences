package com.gravityray.rxsharedpreferences;

import android.content.SharedPreferences;


interface SharedPreferencesGetValueAdapter<T> {
    T get(SharedPreferences sharedPreferences, String key, T defaultValue);
}
