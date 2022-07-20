package com.nusratillo.testtask.data.model.mapper

import com.nusratillo.testtask.data.model.BikeStationProperties
import com.nusratillo.testtask.data.model.response.BikeStationPropertiesResponse

fun BikeStationPropertiesResponse.mapToModel() = BikeStationProperties(
    freeRacks = freeRacks ?: "",
    bikes = bikes ?: "",
    label = label ?: "",
    bikeRacks = bikeRacks ?: "",
    updated = updated ?: ""
)