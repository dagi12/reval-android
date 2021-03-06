package pl.edu.amu.wmi.reval.user.service;


import pl.edu.amu.wmi.reval.user.model.Credentials;
import pl.edu.amu.wmi.reval.user.model.SignInResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/login")
    Call<SignInResponse> signIn(@Body Credentials credentials);

}
