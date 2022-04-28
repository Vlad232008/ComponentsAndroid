package com.example.components.component

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import java.net.URI


class MyContentProvider : ContentProvider(){
    override fun onCreate(): Boolean {
        Log.d("MyLog","Content")
        TODO("Not yet implemented")
    }

    override fun query(
        uri: Uri,                               // The content URI of the words table
        projection: Array<out String>?,         // The columns to return for each row
        selection: String?,                     // Selection criteria
        selectionArgs: Array<out String>?,      // Selection criteria
        sortOrder: String?                      // The sort order for the returned rows
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

}