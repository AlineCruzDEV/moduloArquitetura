package com.digitalhouse.aularevisao.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.digitalhouse.aularevisao.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapterResult: AdapterResult
    lateinit var linearLayoutManager: LinearLayoutManager

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterResult = AdapterResult()
        linearLayoutManager = LinearLayoutManager(this)
        rcResult.adapter = adapterResult
        rcResult.layoutManager = linearLayoutManager
        rcResult.hasFixedSize()

        //atualizando valores da lista
        viewModel.popListResult()

        viewModel.listResults.observe(this){
            adapterResult.addList(it)
            Log.i("MainActivity", it.toString())
        }

    }
}