package pl.edu.amu.wmi.reval.user;

import retrofit2.Call;

public interface UserService {

    Call<User> signIn();
}
