package com.digitalhouse.aula35.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalhouse.aula35.entities.Aluno
import com.digitalhouse.aula35.entities.Produto
import com.digitalhouse.aula35.services.Repository
import com.digitalhouse.aula35.services.repository
import kotlinx.coroutines.launch
import retrofit2.http.GET
import java.lang.Exception

class MainViewModel(repository: Repository): ViewModel() {
    val aluno = MutableLiveData<Aluno>()
    val listAlunos = MutableLiveData<List<Aluno>>()
    val listProdutos = MutableLiveData<List<Produto>>()
    //

    fun getSortAluno(){
        try {
            viewModelScope.launch {
                aluno.value = repository.getSortAlunoRepo()
            }

        }catch (e: Exception){
            Log.e("MainViewModel", e.toString())
        }
    }

    fun getAllAlunos(){
        try {
            viewModelScope.launch {
                listAlunos.value = repository.getAllAlunosRepo()
            }

        }catch (e: Exception){
            Log.e("MainViewModel", e.toString())
        }
    }


}