package pl.edu.amu.wmi.reval.topic;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.common.util.ListUtils;
import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import pl.edu.amu.wmi.reval.subject.SubjectService;
import retrofit2.Response;

public class TopicServiceTest extends AbstractDaggerServiceTest {


    TopicService topicService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        topicService = retrofit.create(TopicService.class);
    }

    @Test
    public void addTopics() throws IOException {
        Response<Void> response = topicService.addTopic("Przykładowy temat").execute();
        Assert.assertEquals(201, response.code());
    }

    @Test
    public void getTopicsTest() throws IOException {
        Response<List<Topic>> topics = topicService.getTopics().execute();
        Assert.assertNotNull(topics.body());
    }

}
