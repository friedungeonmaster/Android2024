package com.example.aviatickets.model.service

import com.example.aviatickets.model.entity.Offer
import retrofit2.Call
import retrofit2.http.GET

interface OfferApiService {
    @GET("offer_list")
    fun getOffers(): Call<List<Offer>>
}