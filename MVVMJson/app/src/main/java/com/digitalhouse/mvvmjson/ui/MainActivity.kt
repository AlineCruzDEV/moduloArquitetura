package com.digitalhouse.mvvmjson.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.digitalhouse.mvvmjson.R

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaGastos = viewModel.getListGastoGson()
        listaGastos.forEach {

            Log.i("MainActivity", it.toString())

        }
    }


}