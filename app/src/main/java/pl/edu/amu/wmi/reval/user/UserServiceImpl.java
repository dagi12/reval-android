package pl.edu.amu.wmi.reval.user;

import android.content.Intent;

import pl.edu.amu.wmi.reval.MockData;
import pl.edu.amu.wmi.reval.SignInActivity;

import static pl.edu.amu.wmi.reval.di.MyApplication.getContext;

public class UserServiceImpl {

    private UserService userService;
    private UserContext userContext;

    public UserServiceImpl(UserService userService, UserContext userContext) {
        this.userService = userService;
        this.userContext = userContext;
    }

    public void signIn(SignInAdapter adapter, boolean asAdmin) {
        userContext.setUser(MockData.mockedUser());
        adapter.onSignInSuccess();
    }

    public interface SignInAdapter {
        void onSignInSuccess();

        void onSignInFailure();
    }

}
