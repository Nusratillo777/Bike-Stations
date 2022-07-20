package com.nusratillo.testtask.ui.bike_stations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.nusratillo.testtask.EMPTY_STRING
import com.nusratillo.testtask.data.model.BikeStation
import com.nusratillo.testtask.databinding.ActivityBikeStationsBinding
import com.nusratillo.testtask.ui.bike_station_detail.BikeStationDetailActivity
import com.nusratillo.testtask.ui.bike_stations.adapter.BikeStationAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BikeStationsActivity : AppCompatActivity() {
    private val bikeStationsViewModel: BikeStationsViewModel by viewModel()
    private lateinit var binding: ActivityBikeStationsBinding
    private lateinit var adapter: BikeStationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBikeStationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        observeUiState()
    }

    private fun initViews() {
        adapter = BikeStationAdapter { selectedBikeStation ->
            BikeStationDetailActivity.startActivityWithParams(
                this@BikeStationsActivity,
                selectedBikeStation
            )
        }
        binding.bikeStationsRv.adapter = adapter
    }

    private fun observeUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                bikeStationsViewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is BikeStationsUiState.Loading -> showLoadingState()
                        is BikeStationsUiState.Success -> showSuccessState(uiState.bikeStations)
                        is BikeStationsUiState.Error -> showErrorState(
                            uiState.exception.message ?: EMPTY_STRING
                        )
                    }
                }
            }
        }
    }

    private fun showLoadingState() {
        with(binding) {
            placeHolder.isVisible = true
            errorContainer.isVisible = false
            pb.isVisible = true
        }
    }

    private fun showErrorState(errorText: String) {
        with(binding) {
            placeHolder.isVisible = true
            errorContainer.isVisible = true
            pb.isVisible = false

            errorTv.text = errorText
            tryAgainBtn.setOnClickListener { bikeStationsViewModel.getBikeStations() }
        }
    }

    private fun showSuccessState(bikeStations: List<BikeStation>) {
        with(binding) {
            placeHolder.isVisible = false
            adapter.setItems(bikeStations)
            emptyInfoTv.isVisible = bikeStations.isEmpty()
        }
    }
}