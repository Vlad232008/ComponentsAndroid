package com.example.components

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.components.component.MyContentProvider


class ContentExampleActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyLog","ContentProvider")
        setContentView(R.layout.activity_content_provider)
        val rs = contentResolver.query(
            MyContentProvider.CONTENT_URI,
            arrayOf(MyContentProvider._ID,
            MyContentProvider.NAME,
            MyContentProvider.MEANING),null,null,MyContentProvider._ID)
        val next:View = findViewById(R.id.next)
        val insert:View = findViewById(R.id.insert)
        val delete:View = findViewById(R.id.delete)
        val update:View = findViewById(R.id.update)
        val clear:View = findViewById(R.id.clear)
        val previous:View = findViewById(R.id.previous)
        val edName:EditText = findViewById(R.id.edName)
        val edContent:EditText = findViewById(R.id.edContent)
        next.setOnClickListener{
            if(rs != null) {
                if (rs.moveToNext()) {
                    edName.setText(rs.getString(1))
                    edContent.setText(rs.getString(2))
                }
            }
        }
        previous.setOnClickListener {
            if(rs != null) {
                if (rs.moveToPrevious()) {
                    edName.setText(rs.getString(1))
                    edContent.setText(rs.getString(2))
                }
            }
        }
        insert.setOnClickListener {
            if(rs != null) {
                val cv = ContentValues()
                cv.put(MyContentProvider.NAME, edName.text.toString())
                cv.put(MyContentProvider.MEANING, edContent.text.toString())
                contentResolver.insert(MyContentProvider.CONTENT_URI, cv)
                rs.requery()
            }
        }
        update.setOnClickListener {
            if(rs != null) {
                val cv = ContentValues()
                cv.put(MyContentProvider.MEANING, edContent.text.toString())
                contentResolver.update(
                    MyContentProvider.CONTENT_URI,
                    cv,
                    "NAME = ?",
                    arrayOf(edName.text.toString())
                )
                rs.requery()
            }
        }
        delete.setOnClickListener {
            if(rs != null) {
                contentResolver.delete(
                    MyContentProvider.CONTENT_URI,
                    "NAME = ?",
                    arrayOf(edName.text.toString())
                )
            }
        }
        clear.setOnClickListener {
            edName.setText("")
            edContent.setText("")
            edName.requestFocus()
        }
    }
}