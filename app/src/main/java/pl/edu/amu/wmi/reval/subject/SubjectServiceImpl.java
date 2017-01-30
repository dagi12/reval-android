package pl.edu.amu.wmi.reval.subject;

import java.util.List;

import pl.edu.amu.wmi.reval.common.services.MyCallback;
import retrofit2.Call;
import retrofit2.Response;

public class SubjectServiceImpl {

    private SubjectService subjectService;

    public SubjectServiceImpl(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public void getSubjects(final SubjectListAdapter adapter) {
        subjectService.getSubjects().enqueue(new MyCallback<List<Subject>>() {
            @Override
            protected void onHandledResponse(Call<List<Subject>> call, Response<List<Subject>> response) {
                adapter.populateSubjects(response.body());
            }
        });
    }

    public Call<Subject> addSubject() {
        return null;
    }

    public interface SubjectListAdapter {
        void populateSubjects(List<Subject> subjects);
    }


}
