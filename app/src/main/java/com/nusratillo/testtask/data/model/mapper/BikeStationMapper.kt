package com.nusratillo.testtask.data.model.mapper

import com.nusratillo.testtask.data.model.BikeStation
import com.nusratillo.testtask.data.model.BikeStationProperties
import com.nusratillo.testtask.data.model.Geometry
import com.nusratillo.testtask.data.model.response.BikeStationResponse

fun BikeStationResponse.mapToModel() = BikeStation(
    geometry = geometry?.mapToModel() ?: Geometry(),
    id = id ?: "",
    type = type ?: "",
    properties = properties?.mapToModel() ?: BikeStationProperties()
)