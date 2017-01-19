package pl.edu.amu.wmi.reval.task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TaskService {

    @GET("api/subject_list/?format=json")
    Call<List<Task>> getTasks();

    @GET("api/answers/?format=json")
    Call<List<Answer>> getAnswers();

    @GET("api/similar_answers/?format=json")
    Call<List<Answer>> getSimilarAnswers();

    @GET("reports_analyzer/analyze_reports/topic={id}")
    Call<Void> analyzeTopic(@Path("id") int topicId);

    @GET("api/newsubject/{name}")
    Call<Void> addSubject(@Path("name") String name);

    @GET("api/newsubject/{name}")
    Call<Void> addTopic(@Path("name") String name);

    @GET("api/newsubject/{name}")
    Call<Void> addQuestion(@Body Question name);

    @GET("api/subject_list/?format=json")
    Call<List<String>> getSubjects();

    @GET("api/topic_list/?format=json")
    Call<List<String>> getTopics();

    @GET("api/question_list/?format=json")
    Call<List<String>> getQuestionList();

}
