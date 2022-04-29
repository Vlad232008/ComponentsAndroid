package com.example.components

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.components.component.AirplaneReceiver

class ReceiverExampleActivity: AppCompatActivity() {
    lateinit var receiver: AirplaneReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_example)
        actionBarSetting()
        //присваиваем переменной класс вещателя
        receiver = AirplaneReceiver()
        //Регистрируем вещатель на проверку Режима Полета
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
    }
    //При выходе из активити, отключаем вещатель
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
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
    //В Терминалах сбора данных, используется BroadCast Receiver для отлова отсканированного штрихкода
}