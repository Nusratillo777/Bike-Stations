package com.nusratillo.testtask.data.model

import com.nusratillo.testtask.EMPTY_STRING
import java.io.Serializable

data class BikeStationProperties(
    val freeRacks: String = EMPTY_STRING,
    val bikes: String = EMPTY_STRING,
    val label: String = EMPTY_STRING,
    val bikeRacks: String = EMPTY_STRING,
    val updated: String = EMPTY_STRING
) : Serializable