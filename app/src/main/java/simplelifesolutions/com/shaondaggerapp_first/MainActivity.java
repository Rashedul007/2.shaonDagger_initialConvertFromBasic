package simplelifesolutions.com.shaondaggerapp_first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplelifesolutions.com.shaondaggerapp_first.Retrofit.APIInterface;
import simplelifesolutions.com.shaondaggerapp_first.adapter.MyRecyclerAdapter;
import simplelifesolutions.com.shaondaggerapp_first.di.components.ApiServicesComponent;
import simplelifesolutions.com.shaondaggerapp_first.di.components.DaggerApiServicesComponent;
import simplelifesolutions.com.shaondaggerapp_first.di.modules.ContextModule;
import simplelifesolutions.com.shaondaggerapp_first.models.RandomUsers;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.ClickListener{

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    APIInterface retroInterface;
    final String LOG_TAG = "testLogTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

        ApiServicesComponent mDaggerApiServiceComponent = DaggerApiServicesComponent.builder()
                                                            .build();

        APIInterface retroInterface = mDaggerApiServiceComponent.getApiService() ;


        Call<RandomUsers> retroCall = retroInterface.getPeople(5);

        retroCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
//                Log.d(LOG_TAG, "SUccess:" + response.body().toString());

                mRecyclerAdapter.setItems(response.body().getResults());
                mRecyclerView.setAdapter(mRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Log.d(LOG_TAG, "failed");
                Log.d(LOG_TAG, "MyReason" + t.getCause().toString());
                call.cancel();
            }
        });



    }

    private void initViews()
    {
        mRecyclerView = findViewById(R.id.myRecyclerView);
        mRecyclerAdapter = new MyRecyclerAdapter(MainActivity.this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void funcLaunchIntent(String strGender) {
        Toast.makeText(this, strGender, Toast.LENGTH_SHORT).show();
    }

}
