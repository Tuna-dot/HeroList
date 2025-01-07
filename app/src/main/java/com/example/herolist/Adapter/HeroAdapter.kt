package com.example.herolist.Adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.herolist.Hero
import com.example.herolist.databinding.ItemListBinding

class HeroAdapter(private val heroList: ArrayList<Hero>,
                  private val onClick: (position: Int) -> Unit  )
    : RecyclerView.Adapter<HeroAdapter.ViewHolder>(){

    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            binding.textView.text = hero.name
            Glide.with(binding.root)
                .load(hero.imageUrl)
                .into(binding.imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListBinding.
            inflate(LayoutInflater.
            from(parent.context),
            parent,
            false))
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(heroList[position])
        holder.itemView.setOnClickListener {
            onClick(position)
        }

    }


}