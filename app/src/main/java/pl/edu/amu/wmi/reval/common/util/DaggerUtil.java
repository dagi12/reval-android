package pl.edu.amu.wmi.reval.common.util;

import android.app.Activity;
import android.app.Fragment;

import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.di.MyApplicationComponent;

public class DaggerUtil {

    private DaggerUtil() {
    }

    public static MyApplicationComponent getComponent(Activity context) {
        return ((MyApplication) context.getApplication()).getComponent();
    }

    public static MyApplicationComponent getComponent(Fragment context) {
        return getComponent(context.getActivity());
    }

}
