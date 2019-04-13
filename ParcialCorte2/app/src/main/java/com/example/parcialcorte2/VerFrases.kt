package com.example.parcialcorte2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class VerFrases : AppCompatActivity() {

    private lateinit var nick: String
    private lateinit var volver: Button
    private lateinit var frases: TextView
    private lateinit var nombre: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_frases)

        volver = findViewById(R.id.button7)
        frases = findViewById(R.id.textView7)
        nombre = findViewById(R.id.textView8)

        var bundle = intent.extras
        nick = bundle.getString("nick")

        nombre.text = nick


        //consultar las frases de nick

        volver.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
