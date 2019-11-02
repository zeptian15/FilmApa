package com.septian.rickymaulana.filmapa.Model



import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film (
    var judul : String?,
    // var tahunRilis : String?,
    // var deskripsi : String?,
    //var rating : Float?,
    //var background : Int?,
    var poster : Int?
) : Parcelable