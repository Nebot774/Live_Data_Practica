package com.example.live_data_practica

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class ViewModelFaseDelDia : ViewModel() {
    private val modelo = ModeloFaseDelDia()

    val datosFase: LiveData<String> = modelo.obtenerFase()
}
