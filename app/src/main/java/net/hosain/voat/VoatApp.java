package net.hosain.voat;

import android.app.Application;

import net.hosain.voat.di.AppComponent;
import net.hosain.voat.di.AppModule;
import net.hosain.voat.di.DaggerAppComponent;

import timber.log.Timber;

public class VoatApp extends Application {

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        component = DaggerAppComponent.builder().appModule(new AppModule(getApplicationContext())).build();
    }
}
