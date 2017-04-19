package pl.edu.amu.wmi.reval;

import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import pl.edu.amu.wmi.reval.user.model.User;

public abstract class SignedDaggerServiceTest extends AbstractDaggerServiceTest {

    //  s375195/91122103872
    protected void setUpAdmin() {
        User user = new User();
        user.setToken("bff039d4d16b0823b8cacd0d6bcfb1de8269750b");
        userContext.setUser(user);
    }

    //  s396419/prusio13
    protected void setUpStudent() {
        User user = new User();
        user.setToken("b61f4eb2279ddc7ee1d6a9fa16787cf4786b87be");
        userContext.setUser(user);
    }

}
