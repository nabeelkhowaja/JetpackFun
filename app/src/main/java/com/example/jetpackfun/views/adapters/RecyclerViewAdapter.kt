package com.example.jetpackfun.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackfun.databinding.LayoutListitemBinding
import com.example.jetpackfun.models.datamodels.Location

class RecyclerViewAdapter(private var items: List<Location>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutListitemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
        //image  link contain svg file.. requires work.
        //loadImage(holder.binding.imageView, items.get(position).image.country_flag)
        loadImage(holder.binding.imageView, "https://s-ec.bstatic.com/images/hotel/max1024x768/170/170835226.jpg")
    }

    inner class ViewHolder(val binding: LayoutListitemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Location) {
            binding.location = item
            binding.executePendingBindings()
        }
    }

    fun update(locationItems: List<Location>) {
        items = locationItems
        notifyDataSetChanged();
    }
}