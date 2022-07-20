package com.nusratillo.testtask.app.di

import com.nusratillo.testtask.data.repository.BikeStationRepositoryImpl
import com.nusratillo.testtask.data.repository.BikeStationsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<BikeStationsRepository> {
        BikeStationRepositoryImpl(bikeStationsService = get())
    }
}