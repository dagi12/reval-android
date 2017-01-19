package pl.edu.amu.wmi.reval.user;

import javax.inject.Singleton;

@Singleton
public class UserContext {

    private final PreferencesManager preferencesManager;
    private User user;

    public UserContext(PreferencesManager preferencesManager) {
        this.preferencesManager = preferencesManager;
        this.user = preferencesManager.getDetailedUser();
    }


    public User getUser() {
        return user;
    }


    public boolean isLoggedIn() {
        return user != null;
    }
}