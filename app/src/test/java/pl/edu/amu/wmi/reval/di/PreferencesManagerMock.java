package pl.edu.amu.wmi.reval.di;

import pl.edu.amu.wmi.reval.user.model.User;
import pl.edu.amu.wmi.reval.user.service.PreferencesManager;

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
