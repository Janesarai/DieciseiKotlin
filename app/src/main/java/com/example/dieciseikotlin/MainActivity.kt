package com.example.dieciseikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dieciseikotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = Adapter()
        adapter.setData(PaisesLatam.paises)


    }
}