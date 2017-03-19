package pl.edu.amu.wmi.reval.di;

import pl.edu.amu.wmi.reval.user.PreferencesManager;
import pl.edu.amu.wmi.reval.user.User;

public class PreferencesManagerMock extends PreferencesManager {

    public PreferencesManagerMock() {
        super(null, null);
    }

    @Override
    public void savePref(Object myObject, String prefName) {
        // do nothing in mock
    }

    @Override
    public User getDetailedUser() {
        return null;
    }
}
