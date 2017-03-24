package pl.edu.amu.wmi.reval.user.model;

public class SignInResponse {
    private SignInStatus status;
    private String fullName;
    private String index;
    private String token;

    public User getUserFromResponse(boolean admin) {
        User user = new User();
        user.setName(fullName);
        user.setIndex(index);
        user.setToken(token);
        user.setAdmin(admin);
        return user;
    }

    public SignInStatus getStatus() {
        return status;
    }

    public enum SignInStatus {
        success, failed
    }
}
