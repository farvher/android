package com.example.parcialcorte2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var nickname: EditText
    private lateinit var password: EditText
    private lateinit var mostrarFrase: RadioButton
    private lateinit var guardarFrase: RadioButton

    private lateinit var ingresar: Button
    private lateinit var registro: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nickname = findViewById(R.id.editText)
        password = findViewById(R.id.editText3)

        mostrarFrase = findViewById(R.id.radioButton)
        guardarFrase = findViewById(R.id.radioButton2)

        ingresar = findViewById(R.id.button)
        registro = findViewById(R.id.button2)

        registro.setOnClickListener {
            irARegistro()
        }
        ingresar.setOnClickListener{
            ingresar()
        }


    }

    fun ingresar(){

        //TODO VALIDAR si el usuario existe
        if(mostrarFrase.isChecked){
            var intent = Intent(this,VerFrases::class.java)
            intent.putExtra("nick",nickname.text.toString())
            startActivity(intent)
        } else if (guardarFrase.isChecked){
            var intent = Intent(this,GuardarFrases::class.java)
            intent.putExtra("nick",nickname.text.toString())
            startActivity(intent)
        }

    }

    fun irARegistro() {

        var intent = Intent(this, Registro::class.java)
        startActivity(intent)

    }

    private fun showMessage(msj: String) {
        val notification = Toast.makeText(this, msj, Toast.LENGTH_LONG)
        notification.show()
    }



}
