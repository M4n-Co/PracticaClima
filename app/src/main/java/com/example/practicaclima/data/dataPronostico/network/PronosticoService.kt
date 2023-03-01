package com.example.practicaclima.data.dataPronostico.network

import com.example.practicaclima.data.dataPronostico.model.ListaDias
import com.example.practicaclima.data.dataPronostico.model.ModelPronostico
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PronosticoService @Inject  constructor(
    private val api : PronosticoAPI
) {
    suspend fun getPronosticoFS(ubicacion:String):List<ListaDias>{
        return withContext(Dispatchers.IO){
            val response = api.getPronostico("forecast?$ubicacion&cnt=5&appid=7044addbbdc5aaa8f9bed7b046f540e5&lang=es&units=Metric")
            response.body()!!.listaDias
        }
    }
}