package pl.edu.amu.wmi.reval.di;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {


    private static MyApplicationComponent component;
    private static Context context;

    public static MyApplicationComponent getComponent() {
        return component;
    }

    public void setComponent(MyApplicationComponent component) {
        MyApplication.component = component;
    }

    public static Context getContext() {
        return context;
    }

    private static void assignComponent(Application application) {
        component = DaggerMyApplicationComponent
                .builder()
                .myApplicationModule(new MyApplicationModule(application))
                .build();
    }

    private static void setApplicationContext(MyApplication context) {
        MyApplication.context = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setApplicationContext(this);
        assignComponent(this);
    }
}
