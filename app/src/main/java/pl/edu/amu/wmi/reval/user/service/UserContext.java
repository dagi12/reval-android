package pl.edu.amu.wmi.reval.user.service;

import android.app.Application;
import android.content.Intent;

import javax.inject.Singleton;

import pl.edu.amu.wmi.reval.user.activity.SignInActivity;
import pl.edu.amu.wmi.reval.user.model.User;

@Singleton
public class UserContext {

    private final PreferencesManager preferencesManager;
    private User user;
    private Application application;

    public UserContext(PreferencesManager preferencesManager, Application application) {
        this.application = application;
        this.preferencesManager = preferencesManager;
        this.user = preferencesManager.getDetailedUser();
    }

    public void hardLogout() {
        setUser(null);
        Intent signOutIntent = new Intent(application, SignInActivity.class);
        signOutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        application.startActivity(signOutIntent);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        preferencesManager.saveDetailedUser(user);
        this.user = user;
    }

    public boolean isSignedIn() {
        return user != null;
    }
}