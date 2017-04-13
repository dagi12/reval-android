package pl.edu.amu.wmi.reval.common.services;

import android.app.Application;

public class AbstactRetrofitService {

    protected Application application;

    public AbstactRetrofitService(Application application) {
        this.application = application;
    }

}
