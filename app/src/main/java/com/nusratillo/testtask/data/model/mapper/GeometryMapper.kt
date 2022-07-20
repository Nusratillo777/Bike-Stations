package com.nusratillo.testtask.data.model.mapper

import com.nusratillo.testtask.data.model.Geometry
import com.nusratillo.testtask.data.model.response.GeometryResponse

fun GeometryResponse.mapToModel() = Geometry(
    coordinates = coordinates ?: emptyList()
)