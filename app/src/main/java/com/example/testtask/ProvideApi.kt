package com.example.testtask

import com.example.testtask.model.BIN
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ProvideApi{
    @GET("/{bin}")
        fun checkedBin(@Path("bin") Bin: Long): Call<BIN>
}


internal fun provideApi(): ProvideApi {
    val baseurl = "https://lookup.binlist.net"
    val loginInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loginInterceptor)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(baseurl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(ProvideApi::class.java)
}
