package com.example.practicaclima.UI.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaclima.data.dataClimaActual.model.ModelClimaActual
import com.example.practicaclima.data.dataPronostico.model.ListaDias
import com.example.practicaclima.data.dataPronostico.model.ModelPronostico
import com.example.practicaclima.domain.GetClimaActualUseCase
import com.example.practicaclima.domain.GetPronosticoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClimaViewModel @Inject constructor(
    private val getClimaActualUseCase: GetClimaActualUseCase,
    private val getPronosticoUseCase: GetPronosticoUseCase
): ViewModel() {

    val climaActualVM = MutableLiveData<ModelClimaActual?>()
    val isLoading = MutableLiveData<Boolean>()
    val pronosticoModel = MutableLiveData<List<ListaDias>>()

    fun ClimaDeCiudad(ubicacion:String){
        viewModelScope.launch {
            isLoading.postValue(true)

            val clima = getClimaActualUseCase(ubicacion)
            val pronostico = getPronosticoUseCase(ubicacion)

            climaActualVM.postValue(clima)
            pronosticoModel.postValue(pronostico)

            isLoading.postValue(false)
        }
    }
}