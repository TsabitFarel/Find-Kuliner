package com.example.kulinerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.kulinerapp.POJO.KulinerItem
import com.example.kulinerapp.POJO.NetworkConfig
import com.example.kulinerapp.POJO.ResponseMakanan
import com.example.kulinerapp.POJO.RetrofitInterface
import com.example.kulinerapp.RecyclerView.itemListMakananAdapter
import com.example.kulinerapp.databinding.ActivityDetailBinding
import com.example.kulinerapp.databinding.ActivityMakananBinding
import com.example.kulinerapp.databinding.ItemListMakananBinding
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

class makananActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMakananBinding
    private lateinit var adapterRV: itemListMakananAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        binding = ActivityMakananBinding.inflate(inflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        adapterRV = itemListMakananAdapter()


        binding.rvMakanan.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@makananActivity)
            adapter = adapterRV
        }

        lifecycleScope.launch {
            val retrofit = NetworkConfig.buildService(RetrofitInterface::class.java)
            val topKuliner = retrofit.topKuliner()
            if (topKuliner.isSuccessful) {
                val dataKuliner = topKuliner.body()?.kuliner as List<KulinerItem>
                adapterRV.addData(dataKuliner)
            } else {
                Log.e("RetrofitFailed", topKuliner.errorBody().toString())
            }
        }
    }
}