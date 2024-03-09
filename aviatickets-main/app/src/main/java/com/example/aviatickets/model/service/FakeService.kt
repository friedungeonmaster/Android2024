package com.example.aviatickets.model.service

import com.example.aviatickets.model.entity.Offer
import com.example.aviatickets.model.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FakeService {

    fun fetchOffersFromApi(onResult: (List<Offer>?) -> Unit) {
        ApiClient.offerApiService.getOffers().enqueue(object : Callback<List<Offer>> {
            override fun onResponse(call: Call<List<Offer>>, response: Response<List<Offer>>) {
                if (response.isSuccessful) {
                    // Pass the fetched offers to the callback
                    onResult(response.body())
                } else {
                    // Pass null to indicate an error and handle it appropriately in the UI
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<List<Offer>>, t: Throwable) {
                // Pass null to indicate a failure and handle it appropriately in the UI
                onResult(null)
            }
        })
    }
}