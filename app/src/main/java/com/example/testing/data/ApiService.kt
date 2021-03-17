package com.example.testing.data

import com.example.testing.data.response.JsonText
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//https://www.cbr-xml-daily.ru/daily_json.js

interface ApiService {
    @GET("daily_json.js")
    fun getValuteInf(): Call<JsonText>

}
