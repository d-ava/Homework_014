package com.example.homework_014.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkClient {

    private const val BASE_URL = "https://reqres.in/api/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply{
        level = HttpLoggingInterceptor.Level.BODY
    }

    val okHttpClient by lazy {
        val builder = OkHttpClient().newBuilder()

        builder.addInterceptor(loggingInterceptor)
        builder.build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL).client(okHttpClient)
            //.addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi()))
            .build()

    }

    private fun moshi() =
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()



    val api: PeopleApi by lazy {
        retrofit.create(PeopleApi::class.java)
    }

}