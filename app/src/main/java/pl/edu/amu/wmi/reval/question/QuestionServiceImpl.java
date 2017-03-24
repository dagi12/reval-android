package pl.edu.amu.wmi.reval.question;

import java.util.List;

import pl.edu.amu.wmi.reval.common.services.MyCallback;
import retrofit2.Call;
import retrofit2.Response;

public class QuestionServiceImpl {

    private QuestionService questionService;

    public QuestionServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void getQuestions(final QuestionAdapter questionAdapter) {
        questionService.getQuestions().enqueue(new MyCallback<List<Question>>() {
            @Override
            protected void onHandledResponse(Call<List<Question>> call, Response<List<Question>> response) {
                questionAdapter.setQuestions(response.body());
            }
        });
    }

    public void getFilteredQuestions(final QuestionAdapter adapter, final int topicId) {
        questionService.getFilteredQuestions(topicId).enqueue(new MyCallback<List<Question>>() {
            @Override
            protected void onHandledResponse(Call<List<Question>> call, Response<List<Question>> response) {
                adapter.setQuestions(response.body());
            }
        });
    }

    public void addQuestion(final AddQuestionAdapter adapter, Question question) {
        questionService.addQuestion(question).enqueue(new MyCallback<Question>() {
            @Override
            protected void onHandledResponse(Call<Question> call, Response<Question> response) {
                adapter.success(response.body());
            }
        });
    }

    public interface QuestionAdapter {
        void setQuestions(List<Question> questions);
    }

    public interface AddQuestionAdapter {
        void success(Question question);
    }

}
