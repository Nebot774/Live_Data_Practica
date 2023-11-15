package com.example.live_data_practica

import android.database.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.*

class ModeloFaseDelDia {
    private val fases = listOf("Amanecer", "Día", "Tarde", "Anochecer", "Noche")
    private val faseActual = MutableLiveData<String>()
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    init {
        viewModelScope.launch {
            while (isActive) {
                fases.forEach { fase ->
                    faseActual.postValue(fase)
                    delay(2000) // Espera de 2 segundos entre cada fase
                }
            }
        }
    }

    fun obtenerFase(): LiveData<String> {
        return faseActual
    }
}
