package com.nusratillo.testtask.ui.bike_station_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nusratillo.testtask.R
import com.nusratillo.testtask.data.model.BikeStation
import com.nusratillo.testtask.databinding.ActivityBikeStationDetailBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BikeStationDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBikeStationDetailBinding
    private val viewModel: BikeStationDetailViewModel by viewModel()
    private var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBikeStationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bikeStation =
            intent.getSerializableExtra(SELECTED_BIKE_STATION) as? BikeStation ?: BikeStation()
        viewModel.setBikeStation(bikeStation)

        initListeners()
        configureMap(bikeStation)
        observeData()
    }

    private fun initListeners() {
        binding.backIv.setOnClickListener {
            finish()
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.bikeStationState.collect { bikeStation ->
                    binding.bikeStationV.setProperties(bikeStation.properties)
                    addBikeStationMarker(
                        bikeStation.geometry.coordinates[1],
                        bikeStation.geometry.coordinates[0]
                    )
                }
            }
        }
    }

    private fun configureMap(bikeStation: BikeStation) {
        val supportMap =
            supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?
        supportMap?.getMapAsync {
            googleMap = it
            addBikeStationMarker(
                bikeStation.geometry.coordinates[1],
                bikeStation.geometry.coordinates[0]
            )
        }
    }

    private fun addBikeStationMarker(lat: Double, long: Double) {
        val latLng = LatLng(lat, long)
        val markerOptions = MarkerOptions().position(latLng)
        val cameraPosition = CameraPosition.Builder()
            .target(latLng)
            .zoom(20f)
            .build()

        googleMap?.let {
            it.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }

    companion object {
        const val SELECTED_BIKE_STATION = "selected_bike_station"

        fun startActivityWithParams(context: Context, bikeStation: BikeStation) {
            val intent = Intent(context, BikeStationDetailActivity::class.java)
            intent.putExtra(SELECTED_BIKE_STATION, bikeStation)
            context.startActivity(intent)
        }
    }
}