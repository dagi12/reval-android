package pl.edu.amu.wmi.reval.user;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import pl.edu.amu.wmi.reval.user.model.Credentials;
import pl.edu.amu.wmi.reval.user.model.SignInResponse;
import pl.edu.amu.wmi.reval.user.service.UserService;
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
    public void signInAdmin() throws IOException {
        Credentials credentials = new Credentials("s375195", "91122103872", true);
        Response<SignInResponse> response = userService
                .signIn(credentials)
                .execute();
        Assert.assertEquals(SignInResponse.SignInStatus.success, response.body().getStatus());
    }

    @Test
    public void signInStudent() throws IOException {
        Credentials credentials = new Credentials("s396374", "d9x8asd", true);
        Response<SignInResponse> response = userService
                .signIn(credentials)
                .execute();
        Assert.assertEquals(SignInResponse.SignInStatus.success, response.body().getStatus());
    }

}
