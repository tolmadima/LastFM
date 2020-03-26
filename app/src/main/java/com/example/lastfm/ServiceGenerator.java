package com.example.lastfm;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String TAG = "Retrofit";

    private static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Artist.class, new ArtistsDeserializer())
            .create();

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    private  static Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);


    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)){
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());

            retrofit = builder.build();
        }
        Log.i(TAG, "return");
        return retrofit.create(serviceClass);
    }
}


