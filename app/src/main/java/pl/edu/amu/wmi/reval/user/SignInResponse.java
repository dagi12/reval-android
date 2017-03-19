package pl.edu.amu.wmi.reval.user;

class SignInResponse {
    private SignInStatus status;
    private String fullName;
    private String index;
    private String token;

    User getUserFromResponse(boolean admin) {
        User user = new User();
        user.setName(fullName);
        user.setIndex(index);
        user.setToken(token);
        user.setAdmin(admin);
        return user;
    }

    SignInStatus getStatus() {
        return status;
    }

    enum SignInStatus {
        success, failed
    }
}
