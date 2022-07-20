package com.nusratillo.testtask.data.model.response

import com.google.gson.annotations.SerializedName

class BikeStationsResponse(
    @SerializedName("features") val features: List<BikeStationResponse>?
)