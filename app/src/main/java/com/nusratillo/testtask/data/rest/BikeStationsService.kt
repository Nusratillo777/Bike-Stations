package com.nusratillo.testtask.data.rest

import com.nusratillo.testtask.data.model.response.BikeStationsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BikeStationsService {
    @GET(ServerUrls.BIKE_STATIONS)
    suspend fun getBikeStations(
        @Query("mtype") mType: String = "pub_transport",
        @Query("co") co: String = "stacje_rowerowe"
    ): BikeStationsResponse
}