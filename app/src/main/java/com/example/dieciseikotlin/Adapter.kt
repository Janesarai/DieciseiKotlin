package com.example.dieciseikotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dieciseikotlin.databinding.ItemLayoutBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return  paises.size
    }
    fun  setData(listaPaises: List<Pais>){
        this.paises = listaPaises.toMutableList()
    }
    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun  bind(pais: Pais){
            binding.nombrePais.text = pais.nombre
            binding.banderaImg.load(pais.imgUrl)
        }
    }
}