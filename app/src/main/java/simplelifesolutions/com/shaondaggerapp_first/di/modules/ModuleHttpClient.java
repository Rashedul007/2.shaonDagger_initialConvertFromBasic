package simplelifesolutions.com.shaondaggerapp_first.di.modules;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

//(includes = ContextModule.class)

@Module
public class ModuleHttpClient {

    @Provides
    public OkHttpClient provideHttpClient(HttpLoggingInterceptor mHttpInterceptor) // , Cache mCache)
    {
        OkHttpClient client = new OkHttpClient.Builder()
                                    .addInterceptor(mHttpInterceptor)
                                    //.cache(mCache)
                                    .build();

        return client;
    }

    @Provides
    public HttpLoggingInterceptor provideHttpLogInterceptor()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }


    /*@Provides
    public Cache provideCache(File mCahecFile)
    {
        return new Cache(mCahecFile , 10*1000*1000);

    }

    @Provides
    public File provideFile(Context mContext)
    {
        File fl = new File(mContext.getCacheDir() , "httpCache");
        fl.mkdirs();

        return fl;

    }*/
}
