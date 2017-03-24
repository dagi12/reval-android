package pl.edu.amu.wmi.reval.user.model;

import java.io.Serializable;

public class Credentials implements Serializable {

    private String username;
    private String password;

    private transient boolean asAdmin;

    public Credentials() {
        // retrofit need
    }

    public Credentials(String username, String password, boolean asAdmin) {
        this.username = username;
        this.password = password;
        this.asAdmin = asAdmin;
    }

    public boolean isAsAdmin() {
        return asAdmin;
    }
}
