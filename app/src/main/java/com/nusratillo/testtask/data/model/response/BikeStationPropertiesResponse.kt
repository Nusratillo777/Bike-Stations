package com.nusratillo.testtask.data.model.response

import com.google.gson.annotations.SerializedName

class BikeStationPropertiesResponse(
    @SerializedName("free_racks") val freeRacks: String?,
    @SerializedName("bikes") val bikes: String?,
    @SerializedName("label") val label: String?,
    @SerializedName("bike_racks") val bikeRacks: String?,
    @SerializedName("updated") val updated: String?
)