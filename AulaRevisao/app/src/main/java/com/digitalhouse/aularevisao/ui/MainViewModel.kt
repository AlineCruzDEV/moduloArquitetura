package com.digitalhouse.aularevisao.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val listResults = MutableLiveData<ArrayList<String>>()

    fun popListResult(){
        listResults.value = arrayListOf(
            "bola",
            "carro",
            "alunos",
            "futebol",
            "caneta"
        )
    }
}