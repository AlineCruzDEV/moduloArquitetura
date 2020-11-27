package com.digitalhouse.aularevisao.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.digitalhouse.aularevisao.R

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //atualizando valores da lista
        viewModel.popListResult()

        viewModel.listResults.observe(this){
            Log.i("MainActivity", it.toString())
        }
    }
}