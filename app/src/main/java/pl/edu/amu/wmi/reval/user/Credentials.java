package pl.edu.amu.wmi.reval.user;

import com.google.gson.annotations.Expose;

public class Credentials {

    private String username;
    private String password;

    @Expose(serialize = false, deserialize = false)
    private boolean asAdmin;

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
