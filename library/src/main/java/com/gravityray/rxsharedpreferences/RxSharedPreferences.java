package com.gravityray.rxsharedpreferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.Set;


public class RxSharedPreferences {

    @NonNull
    public static SharedPreferencesValueObservable<String> getString(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            String defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getString);
    }

    @NonNull
    public static SharedPreferencesValueObservable<Set<String>> getStringSet(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            Set<String> defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getStringSet);
    }

    @NonNull
    public static SharedPreferencesValueObservable<Integer> getInt(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            int defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getInt);
    }

    @NonNull
    public static SharedPreferencesValueObservable<Long> getLong(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            long defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getLong);
    }

    @NonNull
    public static SharedPreferencesValueObservable<Float> getFloat(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            float defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getFloat);
    }

    @NonNull
    public static SharedPreferencesValueObservable<Boolean> getBoolean(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            boolean defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getBoolean);
    }
}
