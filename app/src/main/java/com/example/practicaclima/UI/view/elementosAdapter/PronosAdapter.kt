package com.example.practicaclima.UI.view.elementosAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaclima.R
import com.example.practicaclima.data.dataPronostico.model.ListaDias

class PronosAdapter():RecyclerView.Adapter<PronosViewHolder>() {

    var itemsPronos = mutableListOf<ListaDias>()

    fun setItems(list : List<ListaDias>){
        this.itemsPronos.clear()
        this.itemsPronos.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PronosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PronosViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: PronosViewHolder, position: Int) {
        val item : ListaDias = itemsPronos[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemsPronos.size
}