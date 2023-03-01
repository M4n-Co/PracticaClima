package com.example.practicaclima.domain

import com.example.practicaclima.data.dataPronostico.PronosticoModelRepository
import com.example.practicaclima.data.dataPronostico.model.ListaDias
import com.example.practicaclima.data.dataPronostico.model.ModelPronostico
import javax.inject.Inject

class GetPronosticoUseCase @Inject constructor(
    private val repositoryPronos: PronosticoModelRepository
) {
    suspend operator fun invoke(ubicacion:String): List<ListaDias> {
        val pronostico = repositoryPronos.getPronosticoFR(ubicacion)
        return pronostico
    }
}