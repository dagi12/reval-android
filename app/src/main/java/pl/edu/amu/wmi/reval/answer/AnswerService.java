package pl.edu.amu.wmi.reval.answer;

import java.util.List;

import pl.edu.amu.wmi.reval.question.filter.QuestionRequestParameters;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnswerService {

    @GET("api/answer_list/?format=json")
    Call<List<Answer>> getAnswers();

    @GET("api/similaranswer_list/?format=json")
    Call<List<Answer>> getSimilarAnswers();

    @GET("api/run_antiplagiarism")
    Call<List<Answer>> checkUnique(@Body QuestionRequestParameters topic);

    @GET("api/answers/question/{id}")
    Call<List<Answer>> getAnswersByQuestionId(@Path("id") int questionId);

}
