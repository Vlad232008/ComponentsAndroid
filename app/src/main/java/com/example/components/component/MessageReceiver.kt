package com.example.components.component

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MessageReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val isAirplaneModeEnabled = intent.getBooleanExtra("state",false)
        if (isAirplaneModeEnabled){
            Toast.makeText(context, "Режим полета включен", Toast.LENGTH_LONG).show()
        }
        else Toast.makeText(context, "Режим полета выключен", Toast.LENGTH_LONG).show()
    }
}