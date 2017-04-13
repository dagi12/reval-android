package pl.edu.amu.wmi.reval.answer;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.SignedDaggerServiceTest;
import pl.edu.amu.wmi.reval.answer.rate.RateAnswerRequest;
import pl.edu.amu.wmi.reval.common.util.ListUtils;
import retrofit2.Response;

public class AnswerServiceTest extends SignedDaggerServiceTest {


    private static final int FILLED_TOPIC_ID = 3;
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
    public void getSimilarAnswersTest() throws IOException {
        super.setUpAdmin();
        Response<List<AnswerReport>> answers = answerService.getSimilarAnswers(FILLED_TOPIC_ID).execute();
        Assert.assertFalse(ListUtils.isEmpty(answers.body()));
    }

    @Test
    public void rateAnswer() throws IOException {
        super.setUpAdmin();
        Response<Answer> answer = answerService.rateAnswer(new RateAnswerRequest(FILLED_TOPIC_ID, FILLED_TOPIC_ID)).execute();
        Assert.assertNotNull(answer.body());
    }

}
