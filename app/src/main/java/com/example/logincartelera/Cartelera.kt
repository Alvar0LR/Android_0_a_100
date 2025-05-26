package com.example.logincartelera

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.logincartelera.databinding.ActivityCarteleraBinding

class Cartelera : AppCompatActivity() {
    private lateinit var binding: ActivityCarteleraBinding
    private lateinit var adapter: CocheAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCarteleraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coches = mutableListOf<Coche>(
            Coche(2, "Ford Mustang", "https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019_1280.jpg", "Deportivo clásico americano con motor V8 y diseño agresivo.", "30.000 €"),
            Coche(4, "Toyota Corolla", "https://cdn.pixabay.com/photo/2012/05/29/00/43/car-49278_1280.jpg", "Compacto fiable y eficiente, ideal para ciudad y carretera.", "18.000 €"),
            Coche(5, "Volkswagen Golf", "https://images.coches.com/_vn_/volkswagen/Taigo/14a2d46a0369b64ba509bb93699019d9.jpg?w=1920&ar=16:9", "Compacto alemán con excelente equilibrio entre rendimiento y comodidad.", "21.500 €"),
            Coche(4, "Tesla Model S", "https://www.tesla.com/ownersmanual/images/GUID-5543BA62-932F-46C5-B1EF-44707D4726B2-online-en-US.png", "Berlina eléctrica de lujo con aceleración impresionante y conducción autónoma.", "89.990 €"),
            Coche(2, "Chevrolet Camaro", "https://www.chevrolet.com/content/dam/chevrolet/na/us/english/vdc-collections/2025/suvs/suburban/nav-jellies/v2/2025-suburban-3lz-g6m-driver-front-3quarter-nav.jpg?imwidth=1200", "Muscle car potente con diseño moderno y espíritu deportivo.", "33.500 €"),
            Coche(4, "Honda Civic", "https://a.ccdn.es/cnet/contents/media/honda/civic/1159931.jpg/900x505cut/", "Sedán compacto japonés con buen consumo y gran reputación de fiabilidad.", "19.200 €"),
            Coche(4, "BMW Serie 3", "https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019_1280.jpg", "Berlina premium con diseño elegante y dinámica de conducción sobresaliente.", "41.000 €"),
            Coche(5, "Audi A4", "https://cdn.topgear.es/sites/navi.axelspringer.es/public/media/image/2018/06/bmw-m4-audi-rs5-cual-elegir_1.jpg?tf=1920x", "Elegante y tecnológico, el Audi A4 combina lujo y prestaciones equilibradas.", "38.500 €"),
            Coche(3, "Mazda RX-8", "https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019_1280.jpg", "Coupé deportivo con motor rotativo y diseño japonés distintivo.", "22.000 €"),
            Coche(4, "Mercedes Clase C", "https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019_1280.jpg", "Sedán de lujo compacto con acabados premium y conducción suave.", "44.300 €")
        )


        adapter = CocheAdapter(coches){
            val intent = Intent(this, DetailsCocheActivity::class.java)
            intent.putExtra("coche", it)
            startActivity(intent)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this,2 )


        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
               adapter.filter(newText.orEmpty())
                return true
            }
        })


    }
}