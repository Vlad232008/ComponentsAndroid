package com.example.components

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.components.component.MyServices

class ServiceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_activity)
        Log.d("MyLog", "onCreateActivity")
        val startService: View = findViewById(R.id.btnStartService)
        val stopService: View = findViewById(R.id.btnStopService)
        val edTime: EditText = findViewById(R.id.edTime)
        startService.setOnClickListener {
            startService(
                Intent(this, MyServices::class.java).putExtra(
                    "time",
                    edTime.text.toString().toInt()
                )
            )
        }
        stopService.setOnClickListener {
            stopService(Intent(this, MyServices::class.java))
        }
    }
}