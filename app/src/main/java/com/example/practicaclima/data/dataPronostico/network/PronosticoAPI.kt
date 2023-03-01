package com.example.practicaclima.data.dataPronostico.network

import com.example.practicaclima.data.dataPronostico.model.ListaDias
import com.example.practicaclima.data.dataPronostico.model.ModelPronostico
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PronosticoAPI {
    @GET
    suspend fun getPronostico(@Url url:String):Response<ModelPronostico>
}