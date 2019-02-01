package com.gravityray.rxsharedpreferences;


import androidx.annotation.Nullable;

@SuppressWarnings({"WeakerAccess", "unused"})
public class SharedPreferencesValueChangedEvent<T> {

    @Nullable
    private final T value;

    private final boolean valueMissing;

    public SharedPreferencesValueChangedEvent(
            @Nullable T value,
            boolean valueMissing) {
        this.value = value;
        this.valueMissing = valueMissing;
    }

    @Nullable
    public T getValue() {
        return value;
    }

    public boolean isValueMissing() {
        return valueMissing;
    }
}
