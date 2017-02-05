package pl.edu.amu.wmi.reval.task;

import java.util.List;

import pl.edu.amu.wmi.reval.task.filter.TaskRequestParameters;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TaskService {

    @GET("api/question_list/?format=json")
    Call<List<Task>> getTasks();

    @POST("api/question_list/?format=json")
    Call<List<Task>> getFilteredTasks(@Body TaskRequestParameters parameters);

    @POST("api/addTask")
    Call<Task> addTask(Task task);
}