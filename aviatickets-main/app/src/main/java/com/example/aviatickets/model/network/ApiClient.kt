package com.example.aviatickets.model.network

import com.example.aviatickets.model.service.OfferApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/estharossa/fake-api-demo/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    /**
     * think about performing network request
     */
    val offerApiService: OfferApiService by lazy {
        retrofit.create(OfferApiService::class.java)
    }
}