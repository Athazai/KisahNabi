package com.anotherteam.kisahnabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.anotherteam.kisahnabi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    companion object {
        const val DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvBacktomain.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        val dataItem = intent.getParcelableExtra<ResponseRasulNabiItem>(DATA)

        with(binding) {
            imgNabi.load(dataItem!!.avatar)
            txtNamanabi.text = dataItem.nama
            txtDeskripsi.text = dataItem.deskripsi
            txtTmpttinggalnabi.text = dataItem.tpKelahiran
            txtUmurnabi.text = dataItem.usia
        }

    }
}