package pl.edu.amu.wmi.reval.di;

import android.app.Application;

public class MyApplication extends Application {

    private MyApplicationComponent component;

    public MyApplicationComponent getComponent() {
        return component;
    }

    public void setComponent(MyApplicationComponent component) {
        this.component = component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.component = DaggerMyApplicationComponent
                .builder()
                .myApplicationModule(new MyApplicationModule(this))
                .build();
    }
}
