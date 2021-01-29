package com.example.hoffmvp.network;

import com.example.hoffmvp.my_interface.ApiConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder ()
                    .baseUrl ( ApiConfig.HOST_URL )
                    .addConverterFactory ( GsonConverterFactory.create () )
                    .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                    .build ();
        }
        return retrofit;
    }

}
