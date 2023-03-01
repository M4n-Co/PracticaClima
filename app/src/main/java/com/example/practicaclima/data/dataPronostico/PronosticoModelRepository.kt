package com.example.practicaclima.data.dataPronostico

import com.example.practicaclima.data.dataPronostico.model.ListaDias
import com.example.practicaclima.data.dataPronostico.model.ModelPronostico
import com.example.practicaclima.data.dataPronostico.network.PronosticoService
import javax.inject.Inject

class PronosticoModelRepository @Inject constructor(
    private val api: PronosticoService
) {
    suspend fun getPronosticoFR(ubicacion:String): List<ListaDias> {
        val response = api.getPronosticoFS(ubicacion)
        return response
    }
}