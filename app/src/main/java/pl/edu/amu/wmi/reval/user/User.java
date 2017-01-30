package pl.edu.amu.wmi.reval.user;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class User extends AbstractRevalItem {
    private String token;

    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
