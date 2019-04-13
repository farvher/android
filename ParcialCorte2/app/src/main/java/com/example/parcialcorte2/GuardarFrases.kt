package com.example.parcialcorte2

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class GuardarFrases : AppCompatActivity() {

    private lateinit var nombre: TextView
    private  var idUser : Int = 0
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
        idUser = bundle.getInt("idUser")


        guardarFrase.setOnClickListener{

            val admin =AdminSQLiteOpenHelper (this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registrof = ContentValues()

            registrof.put("frase", frase.text.toString())
            registrof.put("iduser", idUser)
            bd.insert("frases", null, registrof)
            bd.close()
            frase.setText("")
            Toast.makeText(this, "Frase registrada.!!", Toast.LENGTH_SHORT).show()
        }

        volver.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
