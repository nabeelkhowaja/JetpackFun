package com.example.jetpackfun.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackfun.databinding.LayoutListitemBinding
import com.example.jetpackfun.models.Location

class RecyclerViewAdapter(private val items: List<Location>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutListitemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(items[position])
        loadImage(holder.binding.imageView,items.get(position).image)
        holder.binding.tvLocationName.setText("Location: ${items.get(position).name}")
        holder.binding.tvLatitude.setText("Latitude: ${items.get(position).latitude}")
        holder.binding.tvLongitude.setText("Longitude: ${items.get(position).longitude}")
    }

    inner class ViewHolder(val binding: LayoutListitemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Location) {
            binding.location = item
            binding.executePendingBindings()
        }
    }
}