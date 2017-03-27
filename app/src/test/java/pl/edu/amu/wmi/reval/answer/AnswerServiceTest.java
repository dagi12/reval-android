package pl.edu.amu.wmi.reval.answer;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import retrofit2.Response;

public class AnswerServiceTest extends AbstractDaggerServiceTest {


    private AnswerService answerService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        answerService = retrofit.create(AnswerService.class);
    }

    @Test
    public void getAnswersTest() throws IOException {
        Response<List<Answer>> answers = answerService.getAnswers().execute();
        Assert.assertNotNull(answers.body());
    }

    @Test
    public void getSimilarAnswersTest() throws IOException {
        Response<List<Answer>> answers = answerService.getSimilarAnswers(0).execute();
        Assert.assertNotNull(answers.body());
    }

}
