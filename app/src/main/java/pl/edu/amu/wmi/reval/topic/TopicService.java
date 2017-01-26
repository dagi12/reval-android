package pl.edu.amu.wmi.reval.topic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TopicService {

    @POST("api/newtopic/{name}")
    Call<Void> addTopic(@Path("name") String name);

    @GET("api/topic_list/?format=json")
    Call<List<Topic>> getTopics();

}
