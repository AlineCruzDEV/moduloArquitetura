package com.digitalhouse.aularevisao.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.aularevisao.R
import com.digitalhouse.aularevisao.service.repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapterResult: AdapterResult
    lateinit var linearLayoutManager: LinearLayoutManager

    //val viewModel: MainViewModel by viewModels()
    val viewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }

        }
    }

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
        }
        
        setScroller()

    }

    fun setScroller() {
        rcResult.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0){
                    val litem = linearLayoutManager.itemCount
                    val vItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val itens = adapterResult.itemCount
                    if(litem + vItem >= itens){
                        Log.i("TAG", "chamou")
                    }
                }
            }
            
        })
    }
}