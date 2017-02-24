package pl.edu.amu.wmi.reval.topic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TopicService {

    @POST("api/add_topic")
    Call<Void> addTopic(@Body Topic topic);

    @GET("api/topic_list/?format=json")
    Call<List<Topic>> getTopics();

}
