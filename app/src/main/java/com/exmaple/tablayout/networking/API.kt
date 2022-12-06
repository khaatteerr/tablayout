package com.exmaple.tablayout.networking

import com.exmaple.tablayout.model.Country
import com.exmaple.tablayout.model.CountryData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object API {

    private const val BASE_URL = "https://money-gun.herokuapp.com"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: RetroService = retrofit.create(
        RetroService::class.java)

}

interface RetroService {

     @GET("/khater2")
      suspend fun getDataFromApi():  Response<CountryData>

}