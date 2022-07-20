package com.nusratillo.testtask.data.model

import java.io.Serializable

data class Geometry(
    val coordinates: List<Double> = emptyList()
) : Serializable