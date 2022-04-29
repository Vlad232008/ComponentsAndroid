package com.example.components

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.components.component.MyContentProvider


class ContentExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyLog", "ContentProvider")
        setContentView(R.layout.activity_content_provider)
        val projection =
            arrayOf(MyContentProvider._ID, MyContentProvider.NAME, MyContentProvider.MEANING)
        //получаем элементы базы из провайдера
        val rs = contentResolver.query(
            MyContentProvider.CONTENT_URI,
            projection, null, null, null
        )
        val next: View = findViewById(R.id.next)
        val insert: View = findViewById(R.id.insert)
        val delete: View = findViewById(R.id.delete)
        val update: View = findViewById(R.id.update)
        val clear: View = findViewById(R.id.clear)
        val previous: View = findViewById(R.id.previous)
        val edName: EditText = findViewById(R.id.edName)
        val edContent: EditText = findViewById(R.id.edContent)
        //По кнопке "далее", показывает следующее значение базы
        next.setOnClickListener {
            if (rs?.moveToNext()!!) {
                edName.setText(rs.getString(1))
                edContent.setText(rs.getString(2))
            }
        }
        //По кнопке "предыдущий" показывает предыдущий элемент
        previous.setOnClickListener {
            if (rs?.moveToPrevious()!!) {
                edName.setText(rs.getString(1))
                edContent.setText(rs.getString(2))
            }
        }
        //По кнопке "Добавить" добавляет в базу элемент
        insert.setOnClickListener {
            val cv = ContentValues()
            cv.put(MyContentProvider.NAME, edName.text.toString())
            cv.put(MyContentProvider.MEANING, edContent.text.toString())
            contentResolver.insert(MyContentProvider.CONTENT_URI, cv)
            rs?.requery()
        }
        //По кнопке "Обновить" изменяет элемент в базе
        update.setOnClickListener {
            val cv = ContentValues()
            cv.put(MyContentProvider.MEANING, edContent.text.toString())
            contentResolver.update(
                MyContentProvider.CONTENT_URI,
                cv,
                "NAME = ?",
                arrayOf(edName.text.toString())
            )
            rs?.requery()
        }
        //По кнопке "Удалить" удаляет элемент базы
        delete.setOnClickListener {
            contentResolver.delete(
                MyContentProvider.CONTENT_URI,
                "NAME = ?",
                arrayOf(edName.text.toString())
            )
        }
        //по кнопке очистить, очищает поля ввода
        clear.setOnClickListener {
            edName.setText("")
            edContent.setText("")
            edName.requestFocus()
        }
    }
    //ContentProvider используется для получения контактов пользователя, поэтому среди популярных приложений
    //могу привести пример мессенджеров, WhatsApp,Telegram...
}