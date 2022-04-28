package com.example.components

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.components.helperSQL.MyHelperSql

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service: View = findViewById(R.id.btnService)
        val broadcast: View = findViewById(R.id.broadcast)
        val content: View = findViewById(R.id.provider)
        service.setOnClickListener {
            startActivity(Intent(this, ServiceExampleActivity::class.java))
            finish()
        }
        broadcast.setOnClickListener {
            startActivity(Intent(this, ReceiverExampleActivity::class.java))
            finish()
        }
        content.setOnClickListener {
            startActivity(Intent(this, ContentExampleActivity::class.java))
            finish()
        }
    }
}