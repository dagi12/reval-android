package pl.edu.amu.wmi.reval;

import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import pl.edu.amu.wmi.reval.user.User;

public abstract class SignedDaggerServiceTest extends AbstractDaggerServiceTest {

    @Override
    public void setUp() {
        super.setUp();
        User user = new User();
        user.setToken("79eb1833ea302ae0ec7216e92ff38806f5f8b737");
        userContext.setUser(user);
    }
}
