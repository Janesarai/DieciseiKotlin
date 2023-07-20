package com.example.dieciseikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dieciseikotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PaisCallBack {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }
    /* call back puede ser implementado ai sin una funcion en el adapter si no que directamente*/
    private fun initAdapter() {
        val adapter = Adapter()
        adapter.setData(PaisesLatam.paises)
        adapter.callBack = this
        binding.RV.adapter = adapter



    }

    override fun monstrarPais(s: String) {
        binding.infoPoblacion.text= s
    }
}