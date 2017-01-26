package pl.edu.amu.wmi.reval.subject;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import pl.edu.amu.wmi.reval.di.AbstractDaggerServiceTest;
import retrofit2.Response;

public class SubjectServiceTest extends AbstractDaggerServiceTest {

    SubjectService subjectService;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        subjectService = retrofit.create(SubjectService.class);
    }


    @Test
    public void getSubjectsTest() throws InterruptedException, TimeoutException, IOException {
        Response<List<Subject>> response = subjectService.getSubjects().execute();
        Assert.assertNull(response.errorBody());
    }

    @Test
    public void addSubjectTest() throws InterruptedException, TimeoutException, IOException {
        Response<Void> response = subjectService.addSubject("Temat testowy").execute();
        Assert.assertEquals(201, response.code());
    }


}
