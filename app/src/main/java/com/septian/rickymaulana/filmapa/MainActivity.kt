package com.septian.rickymaulana.filmapa

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.septian.rickymaulana.filmapa.Adapter.FilmAdapter
import com.septian.rickymaulana.filmapa.Model.Film

class MainActivity : AppCompatActivity() {
    // Inisialisasi variabel
    private lateinit var listView : ListView
    private lateinit var adapter : FilmAdapter
    private lateinit var dataJudul : Array<String>
    private lateinit var dataPoster : TypedArray
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
    }
    // Method untuk menyiapkan data
    private fun prepare(){
        dataJudul = resources.getStringArray(R.array.data_judul)
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
    }
    // Method untuk menambahkan data ke dalam ListView
    private fun addItem(){
        for (position in dataJudul.indices){
            val film = Film (
                dataJudul[position],
                dataPoster.getResourceId(position, -1)
            )
            films.add(film)
        }
        adapter.films = films
    }
}
