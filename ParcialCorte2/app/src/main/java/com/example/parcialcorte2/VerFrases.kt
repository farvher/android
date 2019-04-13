package com.example.parcialcorte2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class VerFrases : AppCompatActivity() {

    private lateinit var nick: String
    private lateinit var volver: Button
    private lateinit var frases: TextView
    private lateinit var nombre: TextView

    private var idUser: Int = 0
    private var dato1: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_frases)

        volver = findViewById(R.id.button7)
        frases = findViewById(R.id.textView7)
        nombre = findViewById(R.id.textView8)

        var bundle = intent.extras
        nick = bundle.getString("nick")

        nombre.text = nick

        idUser = bundle.getInt("idUser")


        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery("select frase from frases where iduser='${idUser}'", null)
        if (fila.moveToFirst()) {
            do {
                dato1 = dato1 + fila.getString(0) + "\n"

            } while (fila.moveToNext());
        } else {
            Toast.makeText(this, "No existe una frase asociada al usuario.", Toast.LENGTH_SHORT).show()
        }
        frases.text = dato1
        bd.close()


        volver.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
