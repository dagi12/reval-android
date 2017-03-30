package pl.edu.amu.wmi.reval;

import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import pl.edu.amu.wmi.reval.user.model.User;

public abstract class SignedDaggerServiceTest extends AbstractDaggerServiceTest {

    //  s375195/91122103872
    protected void setUpAdmin() {
        User user = new User();
        user.setToken("79eb1833ea302ae0ec7216e92ff38806f5f8b737");
        userContext.setUser(user);
    }

    //  s396419/prusio13
    protected void setUpStudent() {
        User user = new User();
        user.setToken("5811c97aeaebd220e676956e8fe31e95d2f7b6bc");
        userContext.setUser(user);
    }

}
