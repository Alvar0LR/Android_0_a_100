package com.example.logincartelera

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class Coche(
    var puertas: Int,
    var nombre: String,
    var cover: String,
    var descripcion : String,
    var coste: String
): Serializable

// esto por asi decirlo es el objeto que toma de referencia el adpter para poder crear tanto coches como sea
// entiendelo como un objeto en java

