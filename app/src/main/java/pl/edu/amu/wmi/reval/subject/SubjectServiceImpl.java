package pl.edu.amu.wmi.reval.subject;

import java.util.List;

import retrofit2.Call;

public class SubjectServiceImpl {

    private SubjectService subjectService;

    public SubjectServiceImpl(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public Call<List<Subject>> getSubjects(SubjectListAdapter adapter) {
//        return subjectService.getSubjects();
        return null;
    }

    public Call<Subject> addSubject() {
        return null;
    }

    interface SubjectListAdapter {
        void populate(List<Subject> subjects);
    }


}
