package com.digitalhouse.mvvmjson.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.digitalhouse.mvvmjson.models.Gasto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.io.IOException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext


//    fun getListGastos(): ArrayList<Gasto> {
//
//        val listGastos =  arrayListOf<Gasto>()
//
//        try {
//            val jsonString = context.assets.open("gastos.json")
//                .bufferedReader()
//                .use { it.readText() }
//
//            val jsonArray = JSONArray(jsonString)
//
//            for (i in 0 until jsonArray.length()) {
//                val jsonObj = jsonArray.getJSONObject(i)
//
//                val gasto = Gasto(
//                    jsonObj.getInt("id"),
//                    jsonObj.getString("desc"),
//                    jsonObj.getDouble("valor")
//                )
//
//                listGastos.add(gasto)
//            }
//        } catch (ioException: IOException) {
//            Log.e("MainViewModel", ioException.toString())
//        } finally {
//            return listGastos
//        }
//    }

    fun getListGastoGson(): List<Gasto> {

        val jsonString = context.assets.open("gastos.json")
            .bufferedReader()
            .use { it.readText() }

        return Gson().fromJson(jsonString, object : TypeToken<List<Gasto>>() {}.type)


    }
}


