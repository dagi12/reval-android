package pl.edu.amu.wmi.reval.user.service;

import android.content.Intent;

import javax.inject.Singleton;

import pl.edu.amu.wmi.reval.user.activity.SignInActivity;
import pl.edu.amu.wmi.reval.user.model.User;

import static pl.edu.amu.wmi.reval.di.MyApplication.getContext;

@Singleton
public class UserContext {

    private final PreferencesManager preferencesManager;
    private User user;

    public UserContext(PreferencesManager preferencesManager) {
        this.preferencesManager = preferencesManager;
        this.user = preferencesManager.getDetailedUser();
    }

    public void hardLogout() {
        setUser(null);
        Intent signOutIntent = new Intent(getContext(), SignInActivity.class);
        signOutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(signOutIntent);
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