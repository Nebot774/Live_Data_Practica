package com.example.live_data_practica

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.live_data_practica.R.layout.actividad_fase_del_dia

class ActividadFaseDelDia : AppCompatActivity() {

    private lateinit var viewModel: ViewModelFaseDelDia
    private lateinit var textoFase: TextView
    private lateinit var imagenFase: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(actividad_fase_del_dia)

        textoFase = findViewById(R.id.textoFase)
        imagenFase = findViewById(R.id.imagenFase)
        viewModel = ViewModelProvider(this).get(ViewModelFaseDelDia::class.java)

        viewModel.datosFase.observe(this, Observer { fase ->
            textoFase.text = fase
            actualizarImagen(fase)
        })
    }

    private fun actualizarImagen(fase: String) {
        val recursoImagen = when(fase) {
            "Amanecer" -> R.drawable.imagen_amanecer
            "Día" -> R.drawable.imagen_dia
            "Tarde" -> R.drawable.imagen_tarde
            "Anochecer" -> R.drawable.imagen_anochecer
            "Noche" -> R.drawable.imagen_noche
            else -> R.drawable.imagen_amanecer
        }
        imagenFase.setImageResource(recursoImagen)
    }
}
