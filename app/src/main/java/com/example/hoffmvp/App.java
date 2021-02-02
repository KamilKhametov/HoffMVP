package com.example.hoffmvp;

import android.app.Application;

import com.example.hoffmvp.my_interface.ApiConfig;
import com.example.hoffmvp.my_interface.ApiService;
import com.example.hoffmvp.network.DataManager;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate ();

        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( ApiConfig.HOST_URL )
                .addConverterFactory ( GsonConverterFactory.create () )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .build ();

        ApiService apiService = retrofit.create ( ApiService.class );

        dataManager = new DataManager ( apiService );
    }

    public static DataManager getDataManager(){
        return dataManager;
    }
}
