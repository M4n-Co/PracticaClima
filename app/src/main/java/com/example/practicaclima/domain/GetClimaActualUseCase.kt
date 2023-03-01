package com.example.practicaclima.domain

import com.example.practicaclima.data.dataClimaActual.ClimaModelRepository
import com.example.practicaclima.data.dataClimaActual.model.ModelClimaActual
import javax.inject.Inject

class GetClimaActualUseCase @Inject constructor(
    private val repositoryCA: ClimaModelRepository
) {
    suspend operator fun invoke(ubicacion:String):ModelClimaActual{
        val ClimaActual = repositoryCA.getClimaActualFR(ubicacion)
        return ClimaActual
    }
}