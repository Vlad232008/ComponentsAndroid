package com.example.components.component

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val isAirplaneModeEnabled = intent.getBooleanExtra("state",false)
        // Если Режим полета переключен, показать соответствующее сообщение
        if (isAirplaneModeEnabled){
            Toast.makeText(context, "Режим полета включен", Toast.LENGTH_LONG).show()
        }
        else Toast.makeText(context, "Режим полета выключен", Toast.LENGTH_LONG).show()
    }
}