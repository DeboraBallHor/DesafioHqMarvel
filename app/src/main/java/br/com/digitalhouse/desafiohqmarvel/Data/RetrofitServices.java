package br.com.digitalhouse.desafiohqmarvel.Data;

import java.util.concurrent.TimeUnit;

import br.com.digitalhouse.desafiohqmarvel.BuildConfig;

public class RetrofitServices {

    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";
    private static RetrofitServices retrofitServices;
    private static RetrofitServices getRetrofit(){

        if (retrofitServices == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
                httpClient.addNetworkInterceptor(new StethoInterceptor());
            }

            retrofitServices = new RetrofitServices().Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofitServices;
    }

    public static Api getApiService() {
        return getRetrofit().create(Api.class);
    }

}