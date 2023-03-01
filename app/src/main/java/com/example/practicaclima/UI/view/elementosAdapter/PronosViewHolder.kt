package com.example.practicaclima.UI.view.elementosAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaclima.UI.view.MainActivity
import com.example.practicaclima.data.dataPronostico.model.ListaDias
import com.example.practicaclima.databinding.ItemBinding

class PronosViewHolder (view: View):RecyclerView.ViewHolder(view) {

    private val mainActivity = MainActivity()
    private val binding = ItemBinding.bind(view)

    fun bind(item: ListaDias){
        val fecha = item.dt_txt.substring(11,16)
        val descrip = item.clima[0].description
        val temps = item.detallesPronos.temp.toInt().toString() + "°"
        val imagen = item.clima[0].icon

        binding.ivIconoPronostico.setImageResource(mainActivity.setImagen(imagen))
        binding.tvFecha.text = fecha
        binding.tvDescripcionPronostico.text = descrip
        binding.tvTemMxMnPronostico.text = temps
    }
}