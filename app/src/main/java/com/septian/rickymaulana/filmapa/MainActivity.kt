package com.septian.rickymaulana.filmapa

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.septian.rickymaulana.filmapa.Adapter.FilmAdapter
import com.septian.rickymaulana.filmapa.Model.Film

class MainActivity : AppCompatActivity(){
    // Inisialisasi variabel
    private lateinit var listView : ListView
    private lateinit var adapter : FilmAdapter
    private lateinit var dataJudul : Array<String>
    private lateinit var dataTahunRilis : Array<String>
    private lateinit var dataDeskripsi : Array<String>
    private lateinit var dataPoster : TypedArray
    private lateinit var dataBackground : TypedArray
    private var films = arrayListOf<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cari berdasarkan Id
        listView = findViewById(R.id.lv_film)

        // Set Adapter
        adapter = FilmAdapter(this)
        listView.adapter = adapter

        // Panggil method prepare() dan addItem()
        prepare()
        addItem()

        // Set Listener untuk ListView
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            // Ambil data film berdasarkan posisi ListView
            val film = films[position]

            // Pindah ke Activity Detail Film, dengan Parcelabe Film
            val detailFilmActivity = Intent(this@MainActivity, DetailFilmActivity::class.java)
            detailFilmActivity.putExtra(DetailFilmActivity.EXTRA_FILM, film)
            startActivity(detailFilmActivity)
        }
    }

    // Method untuk menyiapkan data
    private fun prepare(){
        dataJudul = resources.getStringArray(R.array.data_judul)
        dataTahunRilis = resources.getStringArray(R.array.data_tahun_rilis)
        dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
        dataBackground = resources.obtainTypedArray(R.array.data_background)
    }

    // Method untuk menambahkan data ke dalam ListView
    private fun addItem(){
        for (position in dataJudul.indices){
            val film = Film (
                dataJudul[position],
                dataTahunRilis[position],
                dataDeskripsi[position],
                dataPoster.getResourceId(position, -1),
                dataBackground.getResourceId(position, -1)
            )
            films.add(film)
        }
        adapter.films = films
    }
}
