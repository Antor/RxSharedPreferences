package com.gravityray.rxsharedpreferences;

import android.content.SharedPreferences;

import java.util.concurrent.atomic.AtomicBoolean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


@SuppressWarnings("unused")
public class SharedPreferencesValueObservable<T>
        extends Observable<SharedPreferencesValueChangedEvent<T>> {

    private static class Listener<T>
            implements SharedPreferences.OnSharedPreferenceChangeListener, Disposable {

        private final SharedPreferences sharedPreferences;
        private final String observedKey;
        private final T defaultValue;
        private final SharedPreferencesGetValueAdapter<T> sharedPreferencesGetValueAdapter;
        private final Observer<? super SharedPreferencesValueChangedEvent<T>> observer;

        private final AtomicBoolean disposed;

        Listener(@NonNull SharedPreferences sharedPreferences,
                @NonNull String observedKey,
                @Nullable T defaultValue,
                @NonNull SharedPreferencesGetValueAdapter<T> sharedPreferencesGetValueAdapter,
                @NonNull Observer<? super SharedPreferencesValueChangedEvent<T>> observer) {
            this.sharedPreferences = sharedPreferences;
            this.observedKey = observedKey;
            this.defaultValue = defaultValue;
            this.sharedPreferencesGetValueAdapter = sharedPreferencesGetValueAdapter;
            this.observer = observer;
            disposed = new AtomicBoolean(false);
        }

        @Override
        public void onSharedPreferenceChanged(
                SharedPreferences sharedPreferences,
                String key) {
            if (isDisposed()) {
                return;
            }
            if (observedKey.equals(key)) {
                observer.onNext(
                        new SharedPreferencesValueChangedEvent<>(
                                sharedPreferencesGetValueAdapter.get(
                                        sharedPreferences,
                                        observedKey,
                                        defaultValue),
                                !sharedPreferences.contains(observedKey)));
            }
        }

        @Override
        public void dispose() {
            if (disposed.compareAndSet(false, true)) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
            }
        }

        @Override
        public boolean isDisposed() {
            return disposed.get();
        }
    }

    private final SharedPreferences sharedPreferences;
    private final String key;
    private final T defaultValue;
    private final SharedPreferencesGetValueAdapter<T> sharedPreferencesGetValueAdapter;

    SharedPreferencesValueObservable(
            @NonNull SharedPreferences sharedPreferences,
            @NonNull String key,
            @Nullable T defaultValue,
            @NonNull SharedPreferencesGetValueAdapter<T> sharedPreferencesGetValueAdapter) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.defaultValue = defaultValue;
        this.sharedPreferencesGetValueAdapter = sharedPreferencesGetValueAdapter;
    }

    @Override
    protected void subscribeActual(
            Observer<? super SharedPreferencesValueChangedEvent<T>> observer) {
        subscribeListener(observer);
        observer.onNext(
                new SharedPreferencesValueChangedEvent<>(
                        sharedPreferencesGetValueAdapter.get(
                                sharedPreferences,
                                key,
                                defaultValue),
                        !sharedPreferences.contains(key)));
    }

    @NonNull
    public Observable<SharedPreferencesValueChangedEvent<T>> skipInitial() {
        return new Observable<SharedPreferencesValueChangedEvent<T>>() {
            @Override
            protected void subscribeActual(
                    Observer<? super SharedPreferencesValueChangedEvent<T>> observer) {
                subscribeListener(observer);
            }
        };
    }

    private void subscribeListener(
            @NonNull Observer<? super SharedPreferencesValueChangedEvent<T>> observer) {
        Listener listener = new Listener<>(
                sharedPreferences,
                key,
                defaultValue, sharedPreferencesGetValueAdapter,
                observer);
        observer.onSubscribe(listener);
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }
}
