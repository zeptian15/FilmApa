package com.septian.rickymaulana.filmapa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.septian.rickymaulana.filmapa.Model.Film

class DetailFilmActivity : AppCompatActivity() {
    // Inisialisasi Variabel
    private lateinit var tvJudul : TextView
    private lateinit var tvTahunRilis : TextView
    private lateinit var tvDeskripsi : TextView
    private lateinit var imgBackground : ImageView
    private lateinit var imgPoster : ImageView

    // Object Film dari Activity Sebelumnya
    companion object {
        const val EXTRA_FILM = "extra_film"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        // Cari berdasarkan Id
        tvJudul = findViewById(R.id.tv_judul)
        tvTahunRilis = findViewById(R.id.tv_tahun_rilis)
        tvDeskripsi = findViewById(R.id.tv_deskripsi)
        imgBackground = findViewById(R.id.img_background)
        imgPoster = findViewById(R.id.img_poster)

        // Ambil data dari Activity sebelumnya
        val film = intent.getParcelableExtra(EXTRA_FILM) as Film

        // Set Value
        tvJudul.text = film.judul
        tvTahunRilis.text = film.tahunRilis
        tvDeskripsi.text = film.deskripsi
        Glide.with(this).load(film.background).into(imgBackground)
        Glide.with(this).load(film.poster).into(imgPoster)

        // Set Title Action Bar
        supportActionBar?.setTitle(film.judul)
    }
}
