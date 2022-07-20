package com.nusratillo.testtask.ui.bike_stations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nusratillo.testtask.data.model.BikeStation
import com.nusratillo.testtask.data.repository.BikeStationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class BikeStationsViewModel(
    private val bikeStationsRepository: BikeStationsRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<BikeStationsUiState> =
        MutableStateFlow(BikeStationsUiState.Success(emptyList()))
    val uiState: StateFlow<BikeStationsUiState> = _uiState

    init {
        getBikeStations()
    }

    fun getBikeStations() {
        viewModelScope.launch {
            bikeStationsRepository.getBikeStations()
                .onStart {
                    _uiState.value = BikeStationsUiState.Loading
                }
                .flowOn(Dispatchers.IO)
                .catch {
                    _uiState.value = BikeStationsUiState.Error(it)
                }
                .collect {
                    _uiState.value = BikeStationsUiState.Success(it)
                }
        }
    }
}

sealed class BikeStationsUiState {
    data class Success(val bikeStations: List<BikeStation>) : BikeStationsUiState()
    data class Error(val exception: Throwable) : BikeStationsUiState()
    object Loading : BikeStationsUiState()
}