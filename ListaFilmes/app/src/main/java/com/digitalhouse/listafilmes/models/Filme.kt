package com.digitalhouse.listafilmes.models

class Filme(val id: Int, var nome: String, var lancamento: Int, var sinopse: String){
    override fun toString(): String {
        return "Filme(id=$id, nome='$nome', lancamento=$lancamento, sinopse='$sinopse')"
    }
}