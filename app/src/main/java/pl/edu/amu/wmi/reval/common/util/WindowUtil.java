package pl.edu.amu.wmi.reval.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import pl.edu.amu.wmi.reval.R;


public final class WindowUtil {

    private WindowUtil() {
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void changeNotificationBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity
                    .getWindow()
                    .setStatusBarColor(ContextCompat.getColor(activity, R.color.textColorPrimary));
        }
    }

    public static void enableActionBar(Activity activity) {
        if (activity.getActionBar() != null) {
            activity.getActionBar().setDisplayHomeAsUpEnabled(true);
        } else if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            if (appCompatActivity.getSupportActionBar() != null) {
                appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }
}
