package com.nusratillo.testtask.data.repository

import com.nusratillo.testtask.data.model.BikeStation
import kotlinx.coroutines.flow.Flow

interface BikeStationsRepository{
    fun getBikeStations(): Flow<List<BikeStation>>
}