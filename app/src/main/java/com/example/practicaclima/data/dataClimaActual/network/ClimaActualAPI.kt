package com.example.practicaclima.data.dataClimaActual.network

import com.example.practicaclima.data.dataClimaActual.model.ModelClimaActual
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ClimaActualAPI {
    @GET
    suspend fun getClimaActual(@Url url:String):Response<ModelClimaActual>
}