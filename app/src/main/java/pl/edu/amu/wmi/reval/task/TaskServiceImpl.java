package pl.edu.amu.wmi.reval.task;

import java.util.List;

import pl.edu.amu.wmi.reval.common.services.MyCallback;
import pl.edu.amu.wmi.reval.task.filter.TaskRequestParameters;
import retrofit2.Call;
import retrofit2.Response;

public class TaskServiceImpl {

    private TaskService taskService;

    public TaskServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    public void getTasks(final TaskAdapter taskAdapter) {
        taskService.getTasks().enqueue(new MyCallback<List<Task>>() {
            @Override
            protected void onHandledResponse(Call<List<Task>> call, Response<List<Task>> response) {
                taskAdapter.setTasks(response.body());
            }
        });
    }

    public void getFilteredTasks(final TaskAdapter adapter, final TaskRequestParameters parameters) {
        taskService.getFilteredTasks(parameters).enqueue(new MyCallback<List<Task>>() {
            @Override
            protected void onHandledResponse(Call<List<Task>> call, Response<List<Task>> response) {
                adapter.setTasks(response.body());
            }
        });
    }

    public interface TaskAdapter {
        void setTasks(List<Task> tasks);
    }

}
