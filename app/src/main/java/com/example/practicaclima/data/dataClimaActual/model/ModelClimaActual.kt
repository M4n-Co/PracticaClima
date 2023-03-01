package com.example.practicaclima.data.dataClimaActual.model

import com.google.gson.annotations.SerializedName

data class ModelClimaActual(
    @SerializedName("main") val mainCA: DetallesCA,
    @SerializedName("name") val ciudadCA: String,
    @SerializedName("weather") val detallesCA: List<ClimaCA>,
    @SerializedName("wind") val vientoCA: VientoCA
)