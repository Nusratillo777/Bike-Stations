package com.nusratillo.testtask.data.model

import com.nusratillo.testtask.EMPTY_STRING
import java.io.Serializable

data class BikeStation(
    val geometry: Geometry = Geometry(),
    val id: String = EMPTY_STRING,
    val type: String = EMPTY_STRING,
    val properties: BikeStationProperties = BikeStationProperties()
) : Serializable