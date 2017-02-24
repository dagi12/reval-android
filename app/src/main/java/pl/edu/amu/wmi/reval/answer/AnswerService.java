package pl.edu.amu.wmi.reval.answer;

import java.util.List;

import pl.edu.amu.wmi.reval.task.filter.TaskRequestParameters;
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
    Call<List<Answer>> checkUnique(@Body TaskRequestParameters topic);

    @GET("api/answers/task/{id}")
    Call<List<Answer>> getAnswersByTaskId(@Path("id") int taskId);

}
