package com.example.jetpack_component.data_configurations

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



object ApiClient {
    val BASE_URL = "https://mobile-tha-server.firebaseapp.com"
    private val retrofit: Retrofit
    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .build()
    }
    fun getInstance():Retrofit{
        retrofit.let { return retrofit }
    }
}
