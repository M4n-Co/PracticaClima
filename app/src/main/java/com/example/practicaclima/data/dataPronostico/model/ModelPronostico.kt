package com.example.practicaclima.data.dataPronostico.model

import com.google.gson.annotations.SerializedName

data class ModelPronostico(
    @SerializedName("list") val listaDias: List<ListaDias>,
)