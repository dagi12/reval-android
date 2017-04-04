package pl.edu.amu.wmi.reval.answer;

import java.util.List;

import pl.edu.amu.wmi.reval.common.services.MyCallback;
import retrofit2.Call;
import retrofit2.Response;

public class AnswerServiceImpl {

    private final AnswerService answerService;

    public AnswerServiceImpl(AnswerService answerService) {
        this.answerService = answerService;
    }

    public void getAnswers(final AnswerAdapter adapter) {
        answerService.getAnswers().enqueue(new MyCallback<List<Answer>>() {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }


    public void getSimilarAnswers(final AnswerAdapter adapter) {
        answerService.getAnswers().enqueue(new MyCallback<List<Answer>>() {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }


    public void checkUnique(final AnswerAdapter adapter, int parameters) {
        answerService.checkUnique(parameters).enqueue(new MyCallback<List<Answer>>() {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }

    void getAnswersByQuestionId(final AnswerAdapter adapter, int id) {
        answerService.getAnswersByQuestionId(id).enqueue(new MyCallback<List<Answer>>() {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }


    public interface AnswerAdapter {
        void setAnswers(List<Answer> answers);
    }

}
