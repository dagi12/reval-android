package pl.edu.amu.wmi.reval.subject;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import pl.edu.amu.wmi.reval.SignedDaggerServiceTest;
import retrofit2.Response;

public class SubjectServiceTest extends SignedDaggerServiceTest {

    SubjectService subjectService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        subjectService = retrofit.create(SubjectService.class);
    }


    @Test
    public void getSubjectsTestAdmin() throws InterruptedException, TimeoutException, IOException {
        super.setUpAdmin();
        Response<List<Subject>> response = subjectService.getSubjects().execute();
        Assert.assertTrue(response.body().size() > 0);
    }

    @Test
    public void getSubjectsTestStudent() throws InterruptedException, TimeoutException, IOException {
        super.setUpStudent();
        Response<List<Subject>> response = subjectService.getSubjects().execute();
        Assert.assertTrue(response.body().size() > 0);
    }

}
