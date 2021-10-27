package com.example.homework_014.network

import com.example.homework_014.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApi {
    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): Response<User>


}