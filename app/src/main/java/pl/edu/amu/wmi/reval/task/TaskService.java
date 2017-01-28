package pl.edu.amu.wmi.reval.task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskService {

    @GET("api/question_list/?format=json")
    Call<List<Task>> getTasks();

}