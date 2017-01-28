package pl.edu.amu.wmi.reval;

import pl.edu.amu.wmi.reval.user.User;

//TODO do usunięcia gdy gotowe API
public final class MockData {
    private MockData() {
    }

    public static User mockedUser() {
        User user = new User();
        user.setId(0);
        user.setName("Eryk Mariankowski");
        user.setAdmin(false);
        return user;
    }


}
