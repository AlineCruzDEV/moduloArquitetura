package com.digitalhouse.mvvmjson.models

data class Gasto(val id: Int, var desc: String, var valor: Double) {

    override fun toString(): String {
        return "Gasto(id=$id, desc='$desc', valor=$valor)"
    }
}
