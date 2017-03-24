package pl.edu.amu.wmi.reval.topic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TopicService {

    @POST("api/add_topic")
    Call<Void> addTopic(@Body Topic topic);

    @GET("api/topic_list_by_subject/{id}")
    Call<List<Topic>> getTopicsBySubject(@Path("id") int subjectId);

}
