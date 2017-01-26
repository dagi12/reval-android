package pl.edu.amu.wmi.reval.user;

public class User {
    private String token;

    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getToken() {
        return token;
    }
}
