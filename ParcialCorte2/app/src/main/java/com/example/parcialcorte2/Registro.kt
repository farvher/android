package com.example.parcialcorte2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Registro : AppCompatActivity() {


    private lateinit var nick :EditText
    private lateinit var  clave : EditText

    private lateinit var registrar : Button
    private lateinit var volver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nick = findViewById(R.id.editText2)
        clave = findViewById(R.id.editText4)

        registrar = findViewById(R.id.button3)
        volver = findViewById(R.id.button4)

        registrar.setOnClickListener{

            //guardar registro
        }

        volver.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }


    }
}
