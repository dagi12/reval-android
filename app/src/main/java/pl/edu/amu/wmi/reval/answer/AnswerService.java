package pl.edu.amu.wmi.reval.answer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnswerService {

    @GET("api/answers/?format=json")
    Call<List<Answer>> getAnswers();

    @GET("api/similar_answers/?format=json")
    Call<List<Answer>> getSimilarAnswers();

    @GET("reports_analyzer/analyze_reports/topic={id}")
    Call<List<Answer>> checkUnique(@Path("id") int topicId);

}
