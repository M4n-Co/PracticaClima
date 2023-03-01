package com.example.practicaclima.data.dataClimaActual

import com.example.practicaclima.data.dataClimaActual.model.ModelClimaActual
import com.example.practicaclima.data.dataClimaActual.network.ClimaActualService
import javax.inject.Inject

class ClimaModelRepository @Inject constructor(
    private val api: ClimaActualService
){
    suspend fun getClimaActualFR(ubicacion:String):ModelClimaActual{
        val response = api.getClimaActualFS(ubicacion)
        return response
    }
}