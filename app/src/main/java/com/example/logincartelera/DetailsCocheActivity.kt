package com.example.logincartelera

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.logincartelera.databinding.ActivityDetailsCocheBinding

class DetailsCocheActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsCocheBinding
    private lateinit var coche: Coche
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsCocheBinding.inflate(layoutInflater)
        setContentView(binding.root)


         coche = (intent.getSerializableExtra("coche") as? Coche)!!

        coche?.let {
            binding.tvNombreDetalle.text = it.nombre
            binding.tvPuertasDetalle.text = it.puertas.toString()
            Glide.with(this).load(it.cover).into(binding.ivCocheDetalle)
            binding.tvDescripcionDetalle.text = it.descripcion
            binding.tvPrecioDetalle.text = it.coste
        }


    }
}