package com.gravityray.rxsharedpreferences;


public class SharedPreferencesValueChangedEvent<T> {
    private final T value;
    private final boolean valueMissing;

    public SharedPreferencesValueChangedEvent(T value, boolean valueMissing) {
        this.value = value;
        this.valueMissing = valueMissing;
    }

    public T getValue() {
        return value;
    }

    public boolean isValueMissing() {
        return valueMissing;
    }
}
