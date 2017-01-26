package pl.edu.amu.wmi.reval.question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionService {

    @GET("api/question_list/?format=json")
    Call<List<Question>> getQuestions();

}