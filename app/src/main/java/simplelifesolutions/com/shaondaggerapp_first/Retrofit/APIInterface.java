package simplelifesolutions.com.shaondaggerapp_first.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import simplelifesolutions.com.shaondaggerapp_first.models.RandomUsers;

public interface APIInterface {

    @GET("api")
    Call<RandomUsers> getPeople(@Query("results") int size) ;

    @GET("api")
    Call<RandomUsers> getGenderWise(@Query("gender") String strFormat, @Query("results") int size);
}

