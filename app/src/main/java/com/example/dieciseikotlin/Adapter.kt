package com.example.dieciseikotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dieciseikotlin.databinding.ItemLayoutBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()
    var callBack : PaisCallBack? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        var item = paises[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return  paises.size
    }
    fun  setData(listaPaises: List<Pais>){
        this.paises = listaPaises.toMutableList()
    }
    /* inner es anidado permite poder ver otras clases*/
    inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun  bind(item: Pais){

            binding.nombrePais.text = item.nombre
            binding.banderaImg.load(item.imgUrl)
            binding.cardView.setOnClickListener(View.OnClickListener {
                val texto = "Pais:${item.nombre} Poblacion:${item.poblacion}"
                callBack?.monstrarPais(texto)
            })


        }
    }
}


interface PaisCallBack {
    fun monstrarPais(s: String)
}

