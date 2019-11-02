package com.septian.rickymaulana.filmapa.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.septian.rickymaulana.filmapa.Model.Film
import com.septian.rickymaulana.filmapa.R

class FilmAdapter internal constructor(private val context : Context) : BaseAdapter(){
    // Inisialisasi Variabel
    internal var films = arrayListOf<Film>()
    // Implementasi method dari BaseAdapter

    override fun getView(position: Int, view : View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false)
        }
        // Buat viewHolder
        val viewHolder = ViewHolder(itemView as View)

        val film = getItem(position) as Film
        viewHolder.bind(film)
        return itemView
    }

    override fun getItem(i: Int): Any = films[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = films.size

    // Inisialisasi kelas viewHolder
    private inner class ViewHolder internal constructor(view : View){
        private val tvJudul : TextView = view.findViewById(R.id.tv_judul)
        private val imgBackground : ImageView = view.findViewById(R.id.img_background)

        internal fun bind(film : Film){
            tvJudul.text = film.judul
            Glide.with(context).load(film.poster).into(imgBackground)
        }
    }
}