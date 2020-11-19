package com.example.kulinerapp.RecyclerView

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kulinerapp.POJO.KulinerItem
import com.example.kulinerapp.databinding.ItemListMakananBinding
import com.google.android.material.card.MaterialCardView

class itemListMakananViewHolder(binding: ItemListMakananBinding) : RecyclerView.ViewHolder(binding.root) {
    private val image: ImageView = binding.imageMakanan
    private val title: TextView = binding.titleMakanan
    private val category: TextView = binding.categoryMakanan
    private val root: MaterialCardView = binding.root

    fun bind(makanan: KulinerItem){
        title.text = makanan.nama
        category.text = makanan.kategori
        Glide.with(root.context).load(makanan.gambarUrl).into(image)
    }
}