package com.nusratillo.testtask.ui.custom_view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.nusratillo.testtask.R
import com.nusratillo.testtask.data.model.BikeStationProperties

class BikeStationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private val titleTV: TextView
    private val availableBikesCountV: InfoWithCountView
    private val availablePlacesCountV: InfoWithCountView

    init {
        inflate(context, R.layout.view_bike_station, this)
        titleTV = findViewById(R.id.title_tv)
        availableBikesCountV = findViewById(R.id.available_bikes_count)
        availablePlacesCountV = findViewById(R.id.available_places_count)
    }

    fun setProperties(properties: BikeStationProperties) {
        titleTV.text = properties.label
        availableBikesCountV.setCountText(properties.bikeRacks)
        availablePlacesCountV.setCountText(properties.freeRacks)
    }
}