package com.digitalhouse.aularevisao.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalhouse.aularevisao.service.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository): ViewModel() {

    val listResults = MutableLiveData<ArrayList<String>>()

    fun popListResult(){
        viewModelScope.launch {
            //exemplo inicial da aula povoando manualmente a lista
//            delay(3000)
//            listResults.value = arrayListOf(
//                "bola",
//                "carro",
//                "alunos",
//                "futebol",
//                "caneta"
//            )

            Log.i("TAG", repository.getResults(
                1,
                10,
                "1",
                "6eb7e8896ec5850c52515a8a23ee97f0",
                "40a3aa568bb269dfad85ae0c4a297181"
            ).toString())
        }
    }
}