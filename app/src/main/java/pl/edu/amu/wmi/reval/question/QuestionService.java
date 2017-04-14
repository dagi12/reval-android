package pl.edu.amu.wmi.reval.question;

import java.util.List;

import pl.edu.amu.wmi.reval.question.add.QuestionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QuestionService {

    @GET("api/question_list")
    Call<List<Question>> getQuestions();

    @POST("api/question_list_by_topic/{id}")
    Call<List<Question>> getFilteredQuestions(@Path("id") int topicId);

    @POST("api/add_question")
    Call<QuestionResponse> addQuestion(@Body Question question);
}