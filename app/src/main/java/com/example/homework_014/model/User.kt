package com.example.homework_014.model


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/*
data class User(
    @SerializedName("page")
    val page: Int,
    @SerializedName( "per_page")
    val perPage: Int,
    @SerializedName( "total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("data")
    val `data`: List<Data>,

    ){

    data class Data(
        @SerializedName( "id")
        val id: Int,
        @SerializedName( "email")
        val email: String,
        @SerializedName( "first_name")
        val firstName: String,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("avatar")
        val avatar: String
    )
}*/






@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "page")
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "data")
    val `data`: List<Data>,

){
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "id")
        val id: Int,
        @Json(name = "email")
        val email: String,
        @Json(name = "first_name")
        val firstName: String,
        @Json(name = "last_name")
        val lastName: String,
        @Json(name = "avatar")
        val avatar: String
    )
}
