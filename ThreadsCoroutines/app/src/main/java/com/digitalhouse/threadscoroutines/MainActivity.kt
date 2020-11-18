package com.digitalhouse.threadscoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Runnable

class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnThread.setOnClickListener {
            Thread(
                Runnable {
                    Thread.sleep(5000)
                    runOnUiThread{
                        tvRes.text = "Click Thread"
                    }
                }
            ).start()

        }

        btnHandler.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                tvRes.text = "Click Handler"
            }, 5000)
        }

        btnCoroutine.setOnClickListener {
            scope.launch {
                delay(5000)
                tvRes.text = "Click Coroutines"
            }
        }
    }
}