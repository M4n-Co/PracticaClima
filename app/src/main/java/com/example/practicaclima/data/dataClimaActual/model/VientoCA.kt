package com.example.practicaclima.data.dataClimaActual.model

import com.google.gson.annotations.SerializedName

data class VientoCA(
    @SerializedName("deg") val direccion: Int,
    val speed: Double
)