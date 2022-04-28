package com.example.components.component

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import com.example.components.helperSQL.MyHelperSql


class MyContentProvider : ContentProvider(){
    companion object {
        //authority Провайдера
        val PROVIDER_NAME = "com.example.components.component"
        //Адрес провайдера
        val URL = "content://$PROVIDER_NAME/ACTABLE"
        //Распарсенный адрес провайдера в URI
        val CONTENT_URI = Uri.parse(URL)

        //Колонки
        val _ID = "_id"
        val NAME = "NAME"
        val MEANING = "MEANING"
    }
    lateinit var db: SQLiteDatabase
    override fun onCreate(): Boolean {
        val helper = MyHelperSql(context)
        db = helper.writableDatabase
        return true
    }
    //По запросу insert
    override fun insert(uri: Uri, values: ContentValues?): Uri {
        db.insert("ACTABLE",null, values)
        context?.contentResolver?.notifyChange(uri, null)
        return uri
    }
    override fun getType(uri: Uri): String {
        return "vnd.android.cursor.dir/$PROVIDER_NAME.ACTABLE"
    }
    //По запросу delete
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val count: Int = db.delete("ACTABLE",selection,selectionArgs)
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }
    //По запросу update
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        val count:Int = db.update("ACTABLE",values,selection,selectionArgs)
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }
    //По запросу query
    override fun query(
        uri: Uri,                               // The content URI of the words table
        projection: Array<out String>?,         // The columns to return for each row
        selection: String?,                     // Selection criteria
        selectionArgs: Array<out String>?,      // Selection criteria
        sortOrder: String?                      // The sort order for the returned rows
    ): Cursor? {
        return db.query("ACTABLE",projection,selection,selectionArgs,null,null, null)
    }
}