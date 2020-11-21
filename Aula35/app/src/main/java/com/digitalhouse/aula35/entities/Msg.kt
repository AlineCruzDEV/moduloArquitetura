package com.digitalhouse.aula35.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Msg(@SerializedName("produtos") @Expose var listaProdutos: List<Produto>)
