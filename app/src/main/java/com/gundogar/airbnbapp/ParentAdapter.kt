package com.gundogar.airbnbapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gundogar.airbnbapp.databinding.ParentRecyclerBinding

class ParentAdapter(private val parents: List<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ParentViewHolder {
        val binding =
            ParentRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(
        holder: ParentViewHolder,
        position: Int
    ) {
        val parent = parents[position]
        holder.binding.tvHeader.text = parent.title
        val childLayoutManager =
            LinearLayoutManager(holder.binding.rvChild.context, RecyclerView.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.binding.rvChild.apply {
            layoutManager = childLayoutManager
            adapter = PopularPlacesAdapter(parent.children)
            setRecycledViewPool(viewPool)
        }

    }


    inner class ParentViewHolder(val binding: ParentRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)


}