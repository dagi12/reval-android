package pl.edu.amu.wmi.reval.user;

import android.net.Credentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/login")
    Call<Token> signIn(@Body Credentials credentials);

}
