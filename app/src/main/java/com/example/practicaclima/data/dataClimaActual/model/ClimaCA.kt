package com.example.practicaclima.data.dataClimaActual.model

import com.google.gson.annotations.SerializedName

data class ClimaCA(
    @SerializedName("description") val descrip: String,
    val icon: String,
    val id: Int,
    @SerializedName("main") val estado: String
)