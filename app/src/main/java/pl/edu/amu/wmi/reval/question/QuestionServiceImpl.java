package pl.edu.amu.wmi.reval.question;

import android.app.Application;

import java.util.List;

import pl.edu.amu.wmi.reval.common.services.AbstactRetrofitService;
import pl.edu.amu.wmi.reval.common.services.MyCallback;
import pl.edu.amu.wmi.reval.question.add.AddQuestionAdapter;
import pl.edu.amu.wmi.reval.question.add.QuestionResponse;
import retrofit2.Call;
import retrofit2.Response;

public class QuestionServiceImpl extends AbstactRetrofitService {

    private QuestionService questionService;

    public QuestionServiceImpl(QuestionService questionService, Application application) {
        super(application);
        this.questionService = questionService;
    }

    protected void getQuestions(final QuestionAdapter questionAdapter) {
        questionService.getQuestions().enqueue(new MyCallback<List<Question>>(application) {
            @Override
            protected void onHandledResponse(Call<List<Question>> call, Response<List<Question>> response) {
                questionAdapter.setQuestions(response.body());
            }
        });
    }

    protected void getFilteredQuestions(final QuestionAdapter adapter, final int topicId) {
        questionService.getFilteredQuestions(topicId).enqueue(new MyCallback<List<Question>>(application) {
            @Override
            protected void onHandledResponse(Call<List<Question>> call, Response<List<Question>> response) {
                adapter.setQuestions(response.body());
            }
        });
    }

    public void addQuestion(final AddQuestionAdapter adapter, final Question question) {
        questionService.addQuestion(question).enqueue(new MyCallback<QuestionResponse>(application) {
            @Override
            protected void onHandledResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                QuestionResponse resultQuestion = response.body();
                if (resultQuestion.isSuccess()) {
                    question.addSuccess(resultQuestion.getQuestion());
                    adapter.success(question);
                }
            }
        });
    }

    protected interface QuestionAdapter {
        void setQuestions(List<Question> questions);
    }

}
