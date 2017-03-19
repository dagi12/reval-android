package pl.edu.amu.wmi.reval.topic;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.SignedDaggerServiceTest;
import retrofit2.Response;

public class TopicServiceTest extends SignedDaggerServiceTest {

    private TopicService topicService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        topicService = retrofit.create(TopicService.class);
    }

    @Test
    public void addTopics() throws IOException {
        Response<Void> response = topicService.addTopic(new Topic("Przykładowy temat", 18)).execute();
        Assert.assertEquals(201, response.code());
    }

    @Test
    public void getTopicsTest() throws IOException {
        Response<List<Topic>> topics = topicService.getTopics().execute();
        Assert.assertTrue(topics.body().size() > 0);
    }

}
