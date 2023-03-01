package com.example.practicaclima.data.dataClimaActual.model

import com.google.gson.annotations.SerializedName

data class DetallesCA(
    @SerializedName("feels_like") val comoSiente: Double,
    @SerializedName("humidity") val Humedad: Int,
    @SerializedName("pressure") val presion: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)