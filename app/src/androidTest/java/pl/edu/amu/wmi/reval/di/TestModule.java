package pl.edu.amu.wmi.reval.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.mockito.Mockito;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.edu.amu.wmi.reval.MockData;
import pl.edu.amu.wmi.reval.common.error.ErrorService;
import pl.edu.amu.wmi.reval.common.error.ErrorServiceImpl;
import pl.edu.amu.wmi.reval.common.services.MyCallback;
import pl.edu.amu.wmi.reval.common.services.PicassoCache;
import pl.edu.amu.wmi.reval.subject.SubjectService;
import pl.edu.amu.wmi.reval.subject.SubjectServiceImpl;
import pl.edu.amu.wmi.reval.task.Task;
import pl.edu.amu.wmi.reval.task.TaskService;
import pl.edu.amu.wmi.reval.task.TaskServiceImpl;
import pl.edu.amu.wmi.reval.topic.TopicService;
import pl.edu.amu.wmi.reval.topic.TopicServiceImpl;
import pl.edu.amu.wmi.reval.user.PreferencesManager;
import pl.edu.amu.wmi.reval.user.UserContext;
import pl.edu.amu.wmi.reval.user.UserService;
import pl.edu.amu.wmi.reval.user.UserServiceImpl;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TestModule {

    private static final String API_URL = "http://reval.usermd.net/";
    private final Application mApplication;

    public TestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    protected SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mApplication);
    }

    @Provides
    @Singleton
    protected Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    protected PreferencesManager providePreferencesManager(SharedPreferences sharedPreferences, Gson gson) {
        return new PreferencesManager(sharedPreferences, gson);
    }

    @Provides
    @Singleton
    protected UserContext provideUserContext() {
        return Mockito.mock(UserContext.class);
    }

    @Provides
    @Singleton
    protected OkHttpClient provideOkHttpClient(final UserContext userContext) {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (userContext.getUser() != null) {
                    request = request.newBuilder().addHeader("Authorization", userContext.getUser().getToken()).build();
                }
                return chain.proceed(request);
            }
        }).build();
    }

    @Provides
    @Singleton
    protected Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit
                .Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_URL)
                .build();
    }

    @Provides
    @Singleton
    protected ErrorServiceImpl provideErrorService(Retrofit retrofit) {
        ErrorService errorService = retrofit.create(ErrorService.class);
        return new ErrorServiceImpl(errorService, Thread.getDefaultUncaughtExceptionHandler());
    }

    @Provides
    @Singleton
    protected PicassoCache provideCachedImageManager() {
        return new PicassoCache();
    }


    @Provides
    @Singleton
    protected SubjectServiceImpl provideSubjectServiceImpl(Retrofit retrofit) {
        return new SubjectServiceImpl(retrofit.create(SubjectService.class));
    }

    @Provides
    @Singleton
    protected UserServiceImpl provideUserService(Retrofit retrofit, UserContext userContext) {
        return new UserServiceImpl(retrofit.create(UserService.class), userContext);
    }

    @Provides
    @Singleton
    protected TaskServiceImpl provideTaskService(Retrofit retrofit) {
        return new TaskServiceImpl(retrofit.create(TaskService.class)) {
            @Override
            public void getTasks(final TaskAdapter taskAdapter) {
                taskAdapter.setTasks(MockData.mockedTasks());
            }
        };
    }

    @Provides
    @Singleton
    protected TopicServiceImpl provideTopicService(Retrofit retrofit) {
        return new TopicServiceImpl(retrofit.create(TopicService.class));
    }

}
