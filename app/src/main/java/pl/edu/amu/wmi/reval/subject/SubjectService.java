package pl.edu.amu.wmi.reval.subject;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SubjectService {

    @GET("api/subject_list/?format=json")
    Call<List<Subject>> getSubjects();

    @POST("api/add_subject")
    Call<Void> addSubject(@Body Subject subject);

}
