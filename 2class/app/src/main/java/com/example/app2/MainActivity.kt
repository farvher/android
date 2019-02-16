package com.example.app2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var button: Button

    private lateinit var editText: EditText;

    private lateinit var text: EditText

    private var num: Int = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)

        num = (Math.random()*100001).toInt()

        var cadena = num.toString()
        val notificacion = Toast.makeText(this, cadena, Toast.LENGTH_LONG)
        notificacion.show()

    }


    fun acercade(view: View): Unit {
        val intent = Intent(this, Acercade::class.java)
        startActivity(intent)
    }

    fun controlar(v: View): Unit {

        var valorIngresado = editText.text.toString()

        var valor = Integer.parseInt(valorIngresado)

        if(valor == num){

            val notification  = Toast.makeText(this,"Muy bien recordaste el número mostrado.",Toast.LENGTH_LONG)
            notification.show()
        }else{
            val notification  = Toast.makeText(this,"Lo siento pero no es el número que mostré.",Toast.LENGTH_LONG)
            notification.show()

        }
    }


}
