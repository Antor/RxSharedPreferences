package com.gravityray.rxsharedpreferences;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


interface SharedPreferencesGetValueAdapter<T> {

    @Nullable
    T get(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            @Nullable T defaultValue);
}
