package com.gundogar.airbnbapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gundogar.airbnbapp.databinding.ItemPlaceBinding

class PopularPlacesAdapter(private val itemList: List<Place>) :
    RecyclerView.Adapter<PopularPlacesAdapter.PopularPlacesViewHolder>() {

    class PopularPlacesViewHolder(val binding: ItemPlaceBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularPlacesViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularPlacesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularPlacesViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.ivPlace.setImageResource(item.imageResId)
        holder.binding.tvPlaceName.text = item.title
        holder.binding.tvPlaceDescription.text = item.description
    }

    override fun getItemCount(): Int = itemList.size
}
