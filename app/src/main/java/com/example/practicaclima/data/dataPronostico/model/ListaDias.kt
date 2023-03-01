package com.example.practicaclima.data.dataPronostico.model

import com.google.gson.annotations.SerializedName

data class ListaDias(
    val dt_txt: String,
    @SerializedName("main") val detallesPronos: DetallesPronos,
    @SerializedName("weather") val clima: List<ClimaPronos>,
)