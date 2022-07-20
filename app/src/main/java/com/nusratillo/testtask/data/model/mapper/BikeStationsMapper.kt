package com.nusratillo.testtask.data.model.mapper

import com.nusratillo.testtask.data.model.BikeStations
import com.nusratillo.testtask.data.model.response.BikeStationsResponse

fun BikeStationsResponse.mapToModel() = BikeStations(
    bikeStations = features?.map { it.mapToModel() } ?: emptyList()
)