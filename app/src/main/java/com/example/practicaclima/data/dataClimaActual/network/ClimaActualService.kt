package com.example.practicaclima.data.dataClimaActual.network

import com.example.practicaclima.data.dataClimaActual.model.ModelClimaActual
import com.example.practicaclima.data.dataPronostico.network.PronosticoService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClimaActualService @Inject constructor(
    private val api: ClimaActualAPI
){
    suspend fun getClimaActualFS(ubicacion:String):ModelClimaActual{
        return withContext(Dispatchers.IO){
            val response = api.getClimaActual("weather?$ubicacion&appid=7044addbbdc5aaa8f9bed7b046f540e5&units=Metric")
            response.body()!!
        }
    }
}