package com.allbeer.beer

import retrofit2.http.GET

interface BeerApi {
    @GET("v2/beers")
    suspend fun getBeers(): List<Beer>
}