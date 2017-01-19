package pl.edu.amu.wmi.reval.user;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

@Singleton
public class PreferencesManager {

    private static final String DETAILED_USER_PREF_NAME = "DETAILED_USER";
    private final SharedPreferences mPrefs;
    private final Gson gson;

    public PreferencesManager(SharedPreferences mPrefs, Gson gson) {
        this.mPrefs = mPrefs;
        this.gson = gson;
    }

    public void savePref(final Object myObject, final String prefName) {
        new Runnable() {

            @Override
            public void run() {
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                String json = gson.toJson(myObject);
                prefsEditor.putString(prefName, json);
                prefsEditor.apply();
            }
        }.run();
    }

    private <T> T loadPref(Class<T> tClass, String prefName) {
        String json = mPrefs.getString(prefName, null);
        return gson.fromJson(json, tClass);
    }

    public User getDetailedUser() {
        return loadPref(User.class, DETAILED_USER_PREF_NAME);
    }


}
