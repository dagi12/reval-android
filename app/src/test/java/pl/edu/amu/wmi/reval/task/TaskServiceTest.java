package pl.edu.amu.wmi.reval.task;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import pl.edu.amu.wmi.reval.common.util.ListUtils;
import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import retrofit2.Response;

public class TaskServiceTest extends AbstractDaggerServiceTest {

    private TaskService taskService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        taskService = retrofit.create(TaskService.class);
    }

    @Test
    public void getQuestions() throws IOException {
        Response<List<Task>> response = taskService.getTasks().execute();
        Assert.assertFalse(ListUtils.isEmpty(response.body()));
    }

}
