package kz.android.historicalfigures.api

import kz.android.historicalfigures.HistoricalFigure
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Service {
    @Headers("X-Api-Key:w3jqDp5886MMi5LA9ktjNw==sL5jl0HjQKvyqU1q")
    @GET("historicalfigures")
    fun getFiguresByName(@Query("name") name: String): Call<List<HistoricalFigure>>
}