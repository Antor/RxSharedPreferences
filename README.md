# RxSharedPreferences
RxJava 2 adapter for SharedPreferences API in Android

## Getting Started

### Setting up the dependency

The first step is to include RxSharedPreferences into your project, for example,
as a Gradle compile dependency. Make sure to reference `jcenter()` amongst your repositories.

    repositories {
        jcenter()
    }

    ...

    implementation "com.gravityray:rxsharedpreferences:0.1.0"

### Example

To access `SharedPreferences` reactively use static methods of class `RxSharedPreferences` as shown below.

    SharedPreferences sharedPreferences = ...

    RxSharedPreferences.getStringValue(
                    sharedPreferences,
                    "key",
                    "default_value")
                    .subscribe(value -> {
                            // TODO: handle value
                    });

### API explanation

There are 2 sets of methods which allows to access `SharedPreferences` in slightly different ways.

 - Methods with signature `get<Type>()` (e.g. `getString()`). These methods provide fine grain access by returning 
`SharedPreferencesValueObservable`. This `Observable` emits `SharedPreferencesValueChangedEvent`.
When subscribed it starts by emitting event with current value associated with key and then
reports any updates. Emission of initial event can be skipped by calling `skipInitial()` on
`SharedPreferencesValueObservable` before subscribing.
 
 - Methods with signature `get<Type>Value()` (e.g. `getStringValue()`). These methods derived from
 `get<Type>()`. They just add mapping of events to values thus making client code cleaner. Current value
 is always emitted on subscription then followed by updated values. 