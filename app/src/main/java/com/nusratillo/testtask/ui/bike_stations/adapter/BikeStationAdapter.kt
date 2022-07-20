package com.nusratillo.testtask.ui.bike_stations.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nusratillo.testtask.R
import com.nusratillo.testtask.data.model.BikeStation
import com.nusratillo.testtask.databinding.ItemBikeStationBinding
import com.nusratillo.testtask.ui.inflate

class BikeStationAdapter(
    private val bikeStations: MutableList<BikeStation> = mutableListOf(),
    private val bikeStationOnClick: (BikeStation) -> Unit
) : RecyclerView.Adapter<BikeStationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_bike_station, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bikeStations[position])
    }

    override fun getItemCount(): Int = bikeStations.size

    fun setItems(list: List<BikeStation>) {
        bikeStations.clear()
        bikeStations.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBikeStationBinding.bind(itemView)

        fun bind(bikeStation: BikeStation) {
            with(binding) {
                bikeStationV.setProperties(bikeStation.properties)

                bikeStationV.setOnClickListener {
                    bikeStationOnClick(bikeStation)
                }
            }
        }
    }
}