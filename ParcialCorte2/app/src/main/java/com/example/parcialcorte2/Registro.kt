package com.example.parcialcorte2

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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

            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("name", nick.text.toString())
            registro.put("clave", clave.text.toString())
            bd.insert("usuarios", null, registro)
            bd.close()
            nick.setText("")
            clave.setText("")
            Toast.makeText(this, "Usuario registrado.!!", Toast.LENGTH_SHORT).show()

        }

        volver.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }


    }
}
