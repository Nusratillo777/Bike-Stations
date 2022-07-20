package com.nusratillo.testtask.data.repository

import com.nusratillo.testtask.data.model.BikeStation
import com.nusratillo.testtask.data.model.mapper.mapToModel
import com.nusratillo.testtask.data.rest.BikeStationsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class BikeStationRepositoryImpl(
    private val bikeStationsService: BikeStationsService
) : BikeStationsRepository {
    override fun getBikeStations(): Flow<List<BikeStation>> {
        return flow {
            emit(bikeStationsService.getBikeStations())
        }.map {
            it.features?.map { it.mapToModel() } ?: emptyList()
        }
    }
}