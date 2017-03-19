package pl.edu.amu.wmi.reval.user;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import retrofit2.Response;

public class UserServiceTest extends AbstractDaggerServiceTest {

    private UserService userService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        userService = retrofit.create(UserService.class);
    }

    @Test
    public void signIn() throws IOException {
        Response<SignInResponse> response = userService.signIn(new Credentials("s375195", "91122103872", true)).execute();
        Assert.assertEquals(SignInResponse.SignInStatus.success, response.body().getStatus());
    }

}
