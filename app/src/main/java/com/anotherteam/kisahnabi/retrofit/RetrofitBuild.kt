package com.anotherteam.kisahnabi.retrofit

import com.anotherteam.kisahnabi.ResponseRasulNabiItem
import retrofit2.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitBuild {

    private val client : OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://628d82f5368687f3e7048bf1.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

//    private val retrofit2 : Retrofit = Retrofit.Builder()
//        .baseUrl("https://628d82f5368687f3e7048bf1.mockapi.io/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
//        .build()

    fun getData() = retrofit.create(Nabi::class.java)
    fun getDataRasul() = retrofit.create(Rasul::class.java)

    interface Nabi {
        @GET("v1/nabibaru")

        fun getDataNabi(): Call<List<ResponseRasulNabiItem>>
    }

    interface Rasul {
        @GET("v1/rasul")

        fun getDataRasul(): Call<List<ResponseRasulNabiItem>>
    }
}