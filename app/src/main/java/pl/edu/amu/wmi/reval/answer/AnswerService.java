package pl.edu.amu.wmi.reval.answer;

import java.util.List;

import pl.edu.amu.wmi.reval.question.filter.QuestionRequestParameters;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnswerService {

    @GET("api/answer_list")
    Call<List<Answer>> getAnswers();

    @GET("api/similaranswer_list/{id}")
    Call<List<Answer>> getSimilarAnswers(@Path("id") int topicId);

    @GET("api/similar_report_list/{id}")
    Call<List<Answer>> getSimilarReport(@Path("id") int topicId);

    @GET("api/run_antiplagiarism/{id}")
    Call<List<Answer>> checkUnique(@Body QuestionRequestParameters topic);

    @GET("api/answer_list_by_question/{id}")
    Call<List<Answer>> getAnswersByQuestionId(@Path("id") int questionId);

}
