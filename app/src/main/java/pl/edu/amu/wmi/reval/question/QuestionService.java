package pl.edu.amu.wmi.reval.question;

import java.util.List;

import pl.edu.amu.wmi.reval.question.filter.QuestionRequestParameters;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface QuestionService {

    @GET("api/question_list/")
    Call<List<Question>> getQuestions();

    @POST("api/question_list/?format=json")
    Call<List<Question>> getFilteredQuestions(@Body QuestionRequestParameters parameters);

    @POST("api/add_question")
    Call<Question> addQuestion(@Body Question question);
}