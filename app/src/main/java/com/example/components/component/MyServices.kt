package com.example.components.component

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.util.concurrent.TimeUnit


class MyServices: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        Log.d("MyLog", "onBind")
        return null
    }
    //при создании сервиса
    override fun onCreate() {
        super.onCreate()
        Log.d("MyLog", "onCreate")
    }

    private fun someTask(time: Int) {
        Thread {
            for (i in 1..time) {
                Log.d("MyLog", "i = $i")
                try {
                    TimeUnit.SECONDS.sleep(1)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            stopSelf()
        }.start()
    }
    //При старте сервиса
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyLog", "onStartCommand")
        val time: Int = intent?.getIntExtra("time", 5)!!
        someTask(time)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        val text = "Расчёт окончен"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
        Log.d("MyLog", "onDestroy")
    }
}