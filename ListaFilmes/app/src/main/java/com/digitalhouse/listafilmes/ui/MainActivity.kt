package com.digitalhouse.listafilmes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.digitalhouse.listafilmes.R

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = rvFilme

        recyclerView.adapter = FilmeAdapter(viewModel.getListFilmesGson(), this)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.setHasFixedSize(true)

    }
}