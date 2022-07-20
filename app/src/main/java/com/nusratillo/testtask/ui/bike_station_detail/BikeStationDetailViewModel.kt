package com.nusratillo.testtask.ui.bike_station_detail

import androidx.lifecycle.ViewModel
import com.nusratillo.testtask.data.model.BikeStation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BikeStationDetailViewModel : ViewModel() {
    private val _bikeStationState = MutableStateFlow(BikeStation())
    val bikeStationState: StateFlow<BikeStation> = _bikeStationState

    fun setBikeStation(bikeStation: BikeStation) {
        _bikeStationState.value = bikeStation
    }
}