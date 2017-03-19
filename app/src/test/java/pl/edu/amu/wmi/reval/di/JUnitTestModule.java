package pl.edu.amu.wmi.reval.di;

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
import pl.edu.amu.wmi.reval.user.UserContext;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class JUnitTestModule {

    private static final String API_URL = "http://reval.usermd.net/";


    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    protected UserContext provideUserContext() {
        return new UserContext(new PreferencesManagerMock());
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
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit
                .Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_URL)
                .build();
    }

}
