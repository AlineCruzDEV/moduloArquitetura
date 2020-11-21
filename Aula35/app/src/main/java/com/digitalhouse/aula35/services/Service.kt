package com.digitalhouse.aula35.services

import com.digitalhouse.aula35.entities.Aluno
import com.digitalhouse.aula35.entities.Msg
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface  Repository {

    @GET("sort/aluno")
    suspend fun getSortAlunoRepo(): Aluno

    @GET("alunos")
    suspend fun getAllAlunosRepo(): List<Aluno>

    //AQUI PODERIA IMPORTAR POST, DELETE E TAL

    @GET("produtos")
    suspend fun getAllProdutosRepo(): Msg
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://promoios.com.br/api/ ")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)