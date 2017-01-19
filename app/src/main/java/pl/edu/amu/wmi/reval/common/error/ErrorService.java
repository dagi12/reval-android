package pl.edu.amu.wmi.reval.common.error;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ErrorService {

    @POST("http://fitbook-api.herokuapp.com/api/v1/error")
    Call<Void> postErrorReport(@Body ErrorReport errorReport);

}
