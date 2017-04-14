package pl.edu.amu.wmi.reval.answer;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.SignedDaggerServiceTest;
import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.answer.rate.RateAnswerRequest;
import pl.edu.amu.wmi.reval.answer.rate.RateResult;
import pl.edu.amu.wmi.reval.answer.report.AnswerReport;
import retrofit2.Response;

public class AnswerServiceTest extends SignedDaggerServiceTest {


    private static final int FILLED_TOPIC_ID = 3;
    private static final int RATE_ANSWER_INT = 8;
    private AnswerService answerService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        answerService = retrofit.create(AnswerService.class);
    }

    @Test
    public void getAnswersTest() throws IOException {
        super.setUpAdmin();
        Response<List<Answer>> answers = answerService.getAnswers().execute();
        Assert.assertNotNull(answers.body());
    }

    @Test
    public void getStudentAnswerTest() throws IOException {
        super.setUpStudent();
        Response<Answer> answer = answerService.getAnswerByUser(FILLED_TOPIC_ID).execute();
        Assert.assertNotNull(answer.body());
    }

    @Test
    public void getSimilarAnswersTest() throws IOException {
        super.setUpAdmin();
        Response<List<AnswerReport>> answers = answerService.getSimilarAnswers(FILLED_TOPIC_ID).execute();
        Assert.assertNotNull(answers.body().get(0).getSimilarity());
    }

    @Test
    public void rateAnswer() throws IOException {
        super.setUpAdmin();
        Response<RateResult> answer = answerService.rateAnswer(new RateAnswerRequest(RATE_ANSWER_INT, RATE_ANSWER_INT)).execute();
        Assert.assertTrue(answer.body().isSuccess());
    }

}
