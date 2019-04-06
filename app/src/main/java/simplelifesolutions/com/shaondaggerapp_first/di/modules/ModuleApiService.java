package simplelifesolutions.com.shaondaggerapp_first.di.modules;

import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import simplelifesolutions.com.shaondaggerapp_first.Retrofit.APIInterface;

@Module(includes = ModuleHttpClient.class)
public class ModuleApiService
{
    @Provides
    public APIInterface provideApiInterface(Retrofit mRetrofit)
    {
       return  mRetrofit.create(APIInterface.class);
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient mOkhttpClient, GsonConverterFactory mGsonConverterfactory)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(mGsonConverterfactory)
                .client(mOkhttpClient)
                .build();


        return retrofit;
    }


    @Provides
    public GsonConverterFactory provideGsonConverterFactory()
    {
        return  GsonConverterFactory.create();

    }

}
