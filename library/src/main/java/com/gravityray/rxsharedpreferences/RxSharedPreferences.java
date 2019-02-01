package com.gravityray.rxsharedpreferences;

import android.content.SharedPreferences;

import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Observable;


@SuppressWarnings({"unused", "WeakerAccess"})
public class RxSharedPreferences {

    @NonNull
    public static Observable<String> getStringValue(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            @NonNull String defaultValue) {
        return getString(sharedPreferences, key, defaultValue)
                .map(SharedPreferencesValueChangedEvent::getValue);
    }

    @NonNull
    public static SharedPreferencesValueObservable<String> getString(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            @Nullable String defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getString);
    }

    @NonNull
    public static Observable<Set<String>> getStringSetValue(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            @NonNull Set<String> defaultValue) {
        return getStringSet(sharedPreferences, key, defaultValue)
                .map(SharedPreferencesValueChangedEvent::getValue);
    }

    @NonNull
    public static SharedPreferencesValueObservable<Set<String>> getStringSet(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            @Nullable Set<String> defaultValue) {
        return new SharedPreferencesValueObservable<>(
                sharedPreferences,
                key,
                defaultValue,
                SharedPreferences::getStringSet);
    }

    @NonNull
    public static Observable<Integer> getIntValue(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            int defaultValue) {
        return getInt(sharedPreferences, key, defaultValue)
                .map(SharedPreferencesValueChangedEvent::getValue);
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
    public static Observable<Long> getLongValue(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            long defaultValue) {
        return getLong(sharedPreferences, key, defaultValue)
                .map(SharedPreferencesValueChangedEvent::getValue);
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
    public static Observable<Float> getFloatValue(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            float defaultValue) {
        return getFloat(sharedPreferences, key, defaultValue)
                .map(SharedPreferencesValueChangedEvent::getValue);
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
    public static Observable<Boolean> getBooleanValue(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            boolean defaultValue) {
        return getBoolean(sharedPreferences, key, defaultValue)
                .map(SharedPreferencesValueChangedEvent::getValue);
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