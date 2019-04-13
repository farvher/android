package com.example.parcialcorte2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class AdminSQLiteOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS usuarios(id INTEGER  PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE, clave TEXT)")
        db.execSQL("CREATE TABLE IF NOT EXISTS frases(id INTEGER  PRIMARY KEY AUTOINCREMENT, iduser INTEGER, frase TEXT, FOREIGN KEY(iduser) REFERENCES usuarios(id))")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}