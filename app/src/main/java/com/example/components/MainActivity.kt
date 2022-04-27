package com.example.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service: View = findViewById(R.id.btnService)
        service.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
            finish()
        }
    }
}