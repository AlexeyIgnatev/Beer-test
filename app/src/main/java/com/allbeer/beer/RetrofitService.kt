package com.allbeer.beer

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    fun provideService(): BeerApi {
        return Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(BeerApi::class.java)
    }
}