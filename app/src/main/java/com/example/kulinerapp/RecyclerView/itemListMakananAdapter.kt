package com.example.kulinerapp.RecyclerView

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kulinerapp.POJO.KulinerItem
import com.example.kulinerapp.databinding.ItemListMakananBinding
import com.example.kulinerapp.detailActivity

class itemListMakananAdapter : RecyclerView.Adapter<itemListMakananViewHolder>() {
    private val listMakanan = ArrayList<KulinerItem>()

    fun addData(data: List<KulinerItem>) {
        listMakanan.clear()
        listMakanan.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemListMakananViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListMakananBinding.inflate(layoutInflater, parent, false)
        return itemListMakananViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return listMakanan.size
    }

    override fun onBindViewHolder(holder: itemListMakananViewHolder, position: Int) {
        val data = listMakanan[position]
        holder.bind(data)
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, detailActivity::class.java).apply {
                putExtra("KULINER_ITEM", data)
            }
            it.context.startActivity(intent)
        }
    }
}