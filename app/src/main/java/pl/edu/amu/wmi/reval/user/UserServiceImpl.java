package pl.edu.amu.wmi.reval.user;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserServiceImpl {

    private UserService userService;
    private UserContext userContext;

    public UserServiceImpl(UserService userService, UserContext userContext) {
        this.userService = userService;
        this.userContext = userContext;
    }

    public void signIn(final SignInAdapter adapter, final Credentials credentials) {
        userService.signIn(credentials).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                SignInResponse signInResponse = response.body();
                if (signInResponse != null &&
                        signInResponse.getStatus() == SignInResponse.SignInStatus.success) {
                    userContext.setUser(signInResponse.getUserFromResponse(credentials.isAsAdmin()));
                    adapter.onSignInSuccess();
                } else {
                    adapter.onSignInFailure();
                }
            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                adapter.onSignInFailure();
            }
        });
    }

    public interface SignInAdapter {
        void onSignInSuccess();

        void onSignInFailure();
    }

}
