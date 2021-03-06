package pl.edu.amu.wmi.reval.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.edu.amu.wmi.reval.answer.AnswerService;
import pl.edu.amu.wmi.reval.answer.AnswerServiceImpl;
import pl.edu.amu.wmi.reval.common.services.PicassoCache;
import pl.edu.amu.wmi.reval.question.QuestionService;
import pl.edu.amu.wmi.reval.question.QuestionServiceImpl;
import pl.edu.amu.wmi.reval.subject.SubjectService;
import pl.edu.amu.wmi.reval.subject.SubjectServiceImpl;
import pl.edu.amu.wmi.reval.topic.TopicService;
import pl.edu.amu.wmi.reval.topic.TopicServiceImpl;
import pl.edu.amu.wmi.reval.user.service.PreferencesManager;
import pl.edu.amu.wmi.reval.user.service.UserContext;
import pl.edu.amu.wmi.reval.user.service.UserService;
import pl.edu.amu.wmi.reval.user.service.UserServiceImpl;
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
    protected SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mApplication);
    }

    @Provides
    @Singleton
    protected Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).addSerializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                        final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                        return expose != null && !expose.serialize();
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                })
                .addDeserializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                        final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                        return expose != null && !expose.deserialize();
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                })
                .create();
    }

    @Provides
    @Singleton
    protected PreferencesManager providePreferencesManager(SharedPreferences sharedPreferences, Gson gson) {
        return new PreferencesManager(sharedPreferences, gson);
    }

    @Provides
    @Singleton
    protected UserContext provideUserContext(PreferencesManager preferencesManager) {
        return new UserContext(preferencesManager, mApplication);
    }

    @Provides
    @Singleton
    protected OkHttpClient provideOkHttpClient(final UserContext userContext) {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (userContext.getUser() != null) {
                    request = request.newBuilder().addHeader("token", userContext.getUser().getToken()).build();
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
    protected PicassoCache provideCachedImageManager() {
        return new PicassoCache(mApplication);
    }


    @Provides
    @Singleton
    protected SubjectServiceImpl provideSubjectServiceImpl(Retrofit retrofit) {
        return new SubjectServiceImpl(retrofit.create(SubjectService.class), mApplication);
    }

    @Provides
    @Singleton
    protected UserServiceImpl provideUserService(Retrofit retrofit, UserContext userContext) {
        return new UserServiceImpl(retrofit.create(UserService.class), userContext);
    }

    @Provides
    @Singleton
    protected QuestionServiceImpl provideQuestionService(Retrofit retrofit) {
        return new QuestionServiceImpl(retrofit.create(QuestionService.class), mApplication);
    }

    @Provides
    @Singleton
    protected TopicServiceImpl provideTopicService(Retrofit retrofit) {
        return new TopicServiceImpl(retrofit.create(TopicService.class), mApplication);
    }

    @Provides
    @Singleton
    AnswerServiceImpl provideAnswerService(Retrofit retrofit) {
        return new AnswerServiceImpl(retrofit.create(AnswerService.class), mApplication);
    }

}
