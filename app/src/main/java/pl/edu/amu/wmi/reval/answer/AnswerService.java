package pl.edu.amu.wmi.reval.answer;

import java.util.List;

import pl.edu.amu.wmi.reval.answer.rate.RateAnswerRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnswerService {

    @GET("api/answer_list")
    Call<List<Answer>> getAnswers();

    @GET("api/answer_list_by_question/{id}")
    Call<List<Answer>> getAnswersByQuestionId(@Path("id") int questionId);

    @GET("api/similaranswer_list/{id}")
    Call<List<AnswerReport>> getSimilarAnswers(@Path("id") int topicId);

    @GET("api/run_antiplagiarism/{id}")
    Call<List<Answer>> checkUnique(@Path("id") int topicId);

    @POST("api/rate_answer")
    Call<Answer> rateAnswer(@Body RateAnswerRequest request);

}
