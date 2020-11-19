package com.example.kulinerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kulinerapp.POJO.KulinerItem
import com.example.kulinerapp.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class detailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var dataIntent: KulinerItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        binding = ActivityDetailBinding.inflate(inflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        dataIntent = intent.getParcelableExtra("KULINER_ITEM") as KulinerItem
        supportActionBar?.title = dataIntent.nama

        binding.titleMakanan.text = dataIntent.nama
        binding.addressMakanan.text = dataIntent.alamat
        binding.categoryMakanan.text = dataIntent.kategori
        binding.timeMakanan.text = dataIntent.jamBukaTutup
        Glide.with(this).load(dataIntent.gambarUrl).into(imageMakanan)
    }
}