package pl.edu.amu.wmi.reval.question;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.SignedDaggerServiceTest;
import pl.edu.amu.wmi.reval.common.util.ListUtils;
import pl.edu.amu.wmi.reval.question.add.QuestionResponse;
import pl.edu.amu.wmi.reval.topic.Topic;
import retrofit2.Response;

public class QuestionServiceTest extends SignedDaggerServiceTest {

    private static final int TOPIC_ID = 3;
    private QuestionService questionService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        questionService = retrofit.create(QuestionService.class);
    }

    @Test
    public void getQuestionsAdmin() throws IOException {
        super.setUpAdmin();
        Response<List<Question>> response = questionService.getQuestions().execute();
        verifyQuestions(response);
    }

    @Test
    public void getQuestionsByTopicId() throws IOException {
        super.setUpAdmin();
        Response<List<Question>> response = questionService.getFilteredQuestions(1).execute();
        verifyQuestions(response);
    }

    @Test
    public void getQuestionsStudent() throws IOException {
        super.setUpStudent();
        Response<List<Question>> response = questionService.getQuestions().execute();
        verifyQuestions(response);
    }

    @Test
    public void addQuestion() throws IOException {
        super.setUpAdmin();
        Response<QuestionResponse> response = questionService.addQuestion(new Question(new Topic("lorem ipsum", 3), "lorem", 3)).execute();
        Assert.assertTrue(response.body().isSuccess());
    }

    private void verifyQuestions(Response<List<Question>> response) {
        Assert.assertFalse(ListUtils.isEmpty(response.body()));
        Question question = response.body().get(0);
        Assert.assertFalse(isEmpty(question.getSubjectName()));
        Assert.assertFalse(isEmpty(question.getTopicName()));
        Assert.assertNotNull(question.getLastActivityDate());
        Assert.assertTrue(question.getMaxPoints() > 0);
    }

}
