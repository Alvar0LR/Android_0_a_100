package com.example.logincartelera

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.logincartelera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //email
    private lateinit var email: String
    //contraseña
    private lateinit var password: String

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            // extraen la info del textview
            email = binding.email.text.toString()
            password = binding.password.text.toString()

            if (email == "juan@user.com" && password == "1234"){
                // eso nos navega a la clase cartelera
                val intent = Intent(this@MainActivity, Cartelera::class.java )
                startActivity(intent)

                Toast.makeText(this, "Bienvenido ${email.substringBefore("@")}" , Toast.LENGTH_SHORT).show()
                // eso del substring nos mostrara juan.. corta antes del arroba @

                //ale super bien
            }else{
                Toast.makeText(this, "Credenciales incorrectas ${email.substringBefore("@")}" , Toast.LENGTH_SHORT).show()
            }

        }


    }
}