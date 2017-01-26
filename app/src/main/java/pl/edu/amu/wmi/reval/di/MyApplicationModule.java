package pl.edu.amu.wmi.reval.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.edu.amu.wmi.reval.common.error.ErrorService;
import pl.edu.amu.wmi.reval.common.error.ErrorServiceImpl;
import pl.edu.amu.wmi.reval.common.services.PicassoCache;
import pl.edu.amu.wmi.reval.subject.SubjectService;
import pl.edu.amu.wmi.reval.subject.SubjectServiceImpl;
import pl.edu.amu.wmi.reval.user.PreferencesManager;
import pl.edu.amu.wmi.reval.user.UserContext;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MyApplicationModule {

    private static final String API_URL = "http://reval.usermd.net/";
    private final Application mApplication;

    public MyApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mApplication);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    PreferencesManager providePreferencesManager(SharedPreferences sharedPreferences, Gson gson) {
        return new PreferencesManager(sharedPreferences, gson);
    }

    @Provides
    @Singleton
    UserContext provideUserContext(PreferencesManager preferencesManager) {
        return new UserContext(preferencesManager);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final UserContext userContext) {
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
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit
                .Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_URL)
                .build();
    }

    @Provides
    @Singleton
    ErrorServiceImpl provideErrorService(Retrofit retrofit) {
        ErrorService errorService = retrofit.create(ErrorService.class);
        return new ErrorServiceImpl(errorService, Thread.getDefaultUncaughtExceptionHandler());
    }

    @Provides
    @Singleton
    PicassoCache provideCachedImageManager() {
        return new PicassoCache();
    }


    @Provides
    @Singleton
    SubjectServiceImpl provideSubjectServiceImpl(Retrofit retrofit) {
        return new SubjectServiceImpl(retrofit.create(SubjectService.class));
    }

}
