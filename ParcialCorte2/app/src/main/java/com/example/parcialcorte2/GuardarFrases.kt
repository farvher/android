package com.example.parcialcorte2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GuardarFrases : AppCompatActivity() {

    private lateinit var nombre: TextView
    private lateinit var frase : EditText
    private lateinit var guardarFrase: Button
    private lateinit var volver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar_frases)

        nombre = findViewById(R.id.textView)
        frase = findViewById(R.id.editText5)
        guardarFrase = findViewById(R.id.button5)
        volver = findViewById(R.id.button6)

        var bundle = intent.extras
        nombre.text = bundle.getString("nick")


        guardarFrase.setOnClickListener{

            //guardar la frase
        }

        volver.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
