package com.nusratillo.testtask.data.model.response

import com.google.gson.annotations.SerializedName

class GeometryResponse(
    @SerializedName("coordinates") val coordinates: List<Double>?
)