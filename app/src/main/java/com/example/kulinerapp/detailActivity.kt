package com.example.kulinerapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.kulinerapp.POJO.KulinerItem
import com.example.kulinerapp.POJO.ResponseMakanan
import com.example.kulinerapp.databinding.ActivityDetailBinding
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_makanan.*
import org.w3c.dom.Text

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
//        binding.run {
//            titleMakanan.text = dataIntent.nama
//            addressMakanan.text = dataIntent.alamat
//            categoryMakanan.text = dataIntent.kategori
//            timeMakanan.text = dataIntent.jamBukaTutup
//            Glide.with(this).load(dataIntent.gambarUrl).into(imageMakanan)
//        }
        binding.titleMakanan.text = dataIntent.nama
        binding.addressMakanan.text = dataIntent.alamat
        binding.categoryMakanan.text = dataIntent.kategori
        binding.timeMakanan.text = dataIntent.jamBukaTutup
        Glide.with(this).load(dataIntent.gambarUrl).into(imageMakanan)
    }
}