package pl.edu.amu.wmi.reval.subject;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SubjectService {

    @GET("api/subject_list/?format=json")
    Call<List<Subject>> getSubjects();

    @POST("api/newsubject/{name}")
    Call<Void> addSubject(@Path("name") String name);

}
