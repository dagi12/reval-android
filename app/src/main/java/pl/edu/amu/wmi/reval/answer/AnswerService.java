package pl.edu.amu.wmi.reval.answer;

import java.util.List;

import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.answer.rate.RateAnswerRequest;
import pl.edu.amu.wmi.reval.answer.rate.RateResult;
import pl.edu.amu.wmi.reval.answer.report.AnswerReport;
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
    Call<List<AnswerReport>> checkUnique(@Path("id") int topicId);

    @GET("api/answer_by_id/{id}")
    Call<Answer> getAnswerByUser(@Path("id") int questionId);

    @POST("api/rate_answer")
    Call<RateResult> rateAnswer(@Body RateAnswerRequest request);

}
