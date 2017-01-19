package pl.edu.amu.wmi.reval.common.error;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static pl.edu.amu.wmi.reval.di.MyApplication.getContext;


public class NetworkContext {

    private NetworkContext() {
    }

    public static boolean isOffline() {
        ConnectivityManager cm =
                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return !(netInfo != null && netInfo.isConnectedOrConnecting());
    }

    public static boolean isOnline() {
        return !isOffline();
    }
}
