package com.example.live_data_practica

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.live_data_practica.ui.theme.Live_Data_PracticaTheme

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelFaseDelDia
    private lateinit var textoFase: TextView
    private lateinit var imagenFase: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar las vistas
        textoFase = findViewById(R.id.textoFase)
        imagenFase = findViewById(R.id.imagenFase)

        // Configurar el ViewModel
        viewModel = ViewModelProvider(this)[ViewModelFaseDelDia::class.java]

        // Observar los cambios en LiveData y actualizar la UI
        viewModel.datosFase.observe(this, { fase ->
            textoFase.text = fase
            actualizarImagen(fase)
        })
    }

    private fun actualizarImagen(fase: String) {
        val imagenId = when (fase) {
            "Amanecer" -> R.drawable.imagen_amanecer
            "Día" -> R.drawable.imagen_dia
            "Tarde" -> R.drawable.imagen_tarde
            "Anochecer" -> R.drawable.imagen_anochecer
            "Noche" -> R.drawable.imagen_noche
            else -> R.drawable.imagen_dia
        }
        imagenFase.setImageResource(imagenId)
    }
}


