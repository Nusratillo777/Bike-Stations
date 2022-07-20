package com.nusratillo.testtask.data.model.response

import com.google.gson.annotations.SerializedName

class BikeStationResponse(
    @SerializedName("geometry") val geometry: GeometryResponse?,
    @SerializedName("id") val id: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("properties") val properties: BikeStationPropertiesResponse?
)