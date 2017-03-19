package pl.edu.amu.wmi.reval.question;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.common.util.ListUtils;
import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import retrofit2.Response;

public class QuestionServiceTest extends AbstractDaggerServiceTest {

    private QuestionService questionService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        questionService = retrofit.create(QuestionService.class);
    }

    @Test
    public void getQuestions() throws IOException {
        Response<List<Question>> response = questionService.getQuestions().execute();
        Assert.assertFalse(ListUtils.isEmpty(response.body()));
    }

}
