package pl.edu.amu.wmi.reval.answer;

import android.app.Application;

import java.util.List;

import pl.edu.amu.wmi.reval.answer.rate.RateAnswerRequest;
import pl.edu.amu.wmi.reval.common.services.AbstactRetrofitService;
import pl.edu.amu.wmi.reval.common.services.MyCallback;
import retrofit2.Call;
import retrofit2.Response;

public class AnswerServiceImpl extends AbstactRetrofitService {

    private final AnswerService answerService;

    public AnswerServiceImpl(AnswerService answerService, Application application) {
        super(application);
        this.answerService = answerService;
    }

    public void getAnswers(final AnswerAdapter adapter) {
        answerService.getAnswers().enqueue(new MyCallback<List<Answer>>(application) {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }


    public void getSimilarAnswers(final AnswerAdapter adapter) {
        answerService.getAnswers().enqueue(new MyCallback<List<Answer>>(application) {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }


    public void checkUnique(final AnswerAdapter adapter, int parameters) {
        answerService.checkUnique(parameters).enqueue(new MyCallback<List<Answer>>(application) {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }

    void getAnswersByQuestionId(final AnswerAdapter adapter, int id) {
        answerService.getAnswersByQuestionId(id).enqueue(new MyCallback<List<Answer>>(application) {
            @Override
            protected void onHandledResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                adapter.setAnswers(response.body());
            }
        });
    }

    public void rateAnswer(final RateAnswerRequest rateAnswerRequest, final RateAnswerAdapter adapter) {
        answerService.rateAnswer(rateAnswerRequest).enqueue(new MyCallback<Answer>(application) {
            @Override
            protected void onHandledResponse(Call<Answer> call, Response<Answer> response) {
                adapter.rateSuccess(response.body());
            }
        });
    }


    public interface AnswerAdapter {
        void setAnswers(List<Answer> answers);
    }

    public interface RateAnswerAdapter {
        void rateSuccess(Answer answer);
    }

}
