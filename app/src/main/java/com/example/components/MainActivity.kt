package com.example.components

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.components.component.MessageReceiver

class MainActivity : AppCompatActivity() {

    lateinit var receiver: MessageReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = MessageReceiver()
        val service: View = findViewById(R.id.btnService)
        service.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
            finish()
        }
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}