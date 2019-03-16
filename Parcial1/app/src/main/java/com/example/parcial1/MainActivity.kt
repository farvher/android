package com.example.parcial1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    private lateinit var initButtom: Button
    private lateinit var textview5 : TextView
    private var fileName : String  = "resultados2.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview5 = findViewById(R.id.textView5)
        try {
            val archivo = InputStreamReader(
                openFileInput(fileName)
            )
            val br = BufferedReader(archivo)
            var linea = br.readLine()
            var todo = ""
            while (linea != null) {
                todo = todo + linea + "\n"
                linea = br.readLine()
            }
            br.close()
            archivo.close()
            textview5.setText(todo)
        } catch (e: IOException) {
        }

    }

    fun iniciarJuego(v: View) {
        val intent = Intent(this, Adivinar::class.java)
        startActivity(intent)
    }

    fun leerResultados(){


    }
}
