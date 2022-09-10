package com.allbeer.beer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allbeer.beer.databinding.ListItemBinding
import com.bumptech.glide.Glide

class Adapter(private val list: List<Beer>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beer = list[position]
        with(holder.binding) {
            title.text = beer.name
            description.text = beer.description
            Glide.with(image).load(beer.image_url).into(image)
        }
    }

    override fun getItemCount() = list.size
}