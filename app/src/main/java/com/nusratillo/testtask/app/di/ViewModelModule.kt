package com.nusratillo.testtask.app.di

import com.nusratillo.testtask.ui.bike_station_detail.BikeStationDetailViewModel
import com.nusratillo.testtask.ui.bike_stations.BikeStationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        BikeStationsViewModel(bikeStationsRepository = get())
    }
    viewModel {
        BikeStationDetailViewModel()
    }
}