package com.digitalhouse.aularevisao.entities

data class Res(val data: Data)

data class Data(val offset: Int, var results: ArrayList<Results>)

data class Results(val id: Int, var name: String)
