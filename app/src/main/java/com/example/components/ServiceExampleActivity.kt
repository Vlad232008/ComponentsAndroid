package com.example.components

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.components.component.MyServices

class ServiceExampleActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_activity)
        actionBarSetting()
        Log.d("MyLog", "onCreateActivity")
        val startService: View = findViewById(R.id.btnStartService)
        val edTime: EditText = findViewById(R.id.edTime)
        startService.setOnClickListener {
            startService(
                Intent(this, MyServices::class.java).putExtra(
                    "time",
                    edTime.text.toString().toInt()
                )
            )
        }
    }
    //Создаем на верхней панели кнопку назад/домой
    private fun actionBarSetting() {
        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }
    //По кнопке домой возвращаемся в MainActivity
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}