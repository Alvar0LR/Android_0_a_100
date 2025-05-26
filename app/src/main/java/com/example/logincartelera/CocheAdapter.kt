package com.example.logincartelera

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.logincartelera.databinding.ItemCocheBinding
import java.time.temporal.TemporalQuery

// esto es fundamental para que podamos rellenar la info del coche y se muestren los datos
class CocheAdapter(
    private var cochesList: List<Coche> ,
    private var listaOriginal : List<Coche> = listOf(),
    private var listaFiltrada: MutableList<Coche> = mutableListOf(),
    private val onItemClick: (Coche) -> Unit
): RecyclerView.Adapter<CocheAdapter.ViewHolder>() {

    init {
        listaOriginal= cochesList
        listaFiltrada = cochesList.toMutableList()
    }

    fun filter(query: String){
        // declaramos el texto que pondremos en la busqueda
        val texto = query.toLowerCase().trim()
        // la lista filtrada sera la original si no hay texto
        listaFiltrada = if (texto.isEmpty()){
            listaOriginal.toMutableList()
        }else{
            // filtramos la lista original con lo que hay en el texto que este en el buscador
            listaOriginal.filter {
                it.nombre.trim().toLowerCase().contains(texto) || it.puertas.toString().contains(texto)
            }.toMutableList()
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCocheBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coche: Coche) {
            binding.textViewName.text = coche.nombre
            binding.textViewNumber.text = coche.puertas.toString()
            Glide.with(binding.root.context).load(coche.cover).into(binding.imageView)
            binding.root.setOnClickListener {
                onItemClick(coche)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCocheBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaFiltrada[position])
    }

    override fun getItemCount(): Int = listaFiltrada.size

}

