package com.s.recipepuppy.domain.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiClient {
    private static ApiClient instance;
    private final Retrofit mRetrofit;
    private PuppyRecipesAPI mPuppyRecipesAPI;

    //Этот класс должен быть singleton-объектом, todo:почему? + потому что в однопоточном приложении должен быть единственный экземпляр api, и предоставлять глобальную точку доступа к экземпляру этого класса
    public PuppyRecipesAPI puppyRecipesAPI() {
        if (mPuppyRecipesAPI == null) {
            mPuppyRecipesAPI = mRetrofit.create(PuppyRecipesAPI.class);
        }
        return mPuppyRecipesAPI;
    }

    public static ApiClient instance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    private ApiClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();


        mRetrofit = retrofitCreate(httpClient);
    }

    private Retrofit retrofitCreate(final OkHttpClient client) {
        final String BASE_URL = "http://www.recipepuppy.com/api/";
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
