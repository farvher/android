package com.example.spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinner1: Spinner
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById(R.id.editText) as EditText
        et2 = findViewById(R.id.editText2) as EditText
        tv1 = findViewById(R.id.textView) as TextView

        spinner1 = findViewById(R.id.spinner) as Spinner
        val opciones = arrayOf("sumar", "restar", "multiplicar", "dividir")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        spinner1.setAdapter(adapter)

    }

    fun operar(view: View) {
        val valor1 = et1.getText().toString()
        val valor2 = et2.getText().toString()
        val nro1 = Integer.parseInt(valor1)
        val nro2 = Integer.parseInt(valor2)
        val selec = spinner1.getSelectedItem().toString()
        if (selec == "sumar") {
            val suma = nro1 + nro2
            val resu = suma.toString()
            tv1.setText(resu)
        } else if (selec == "restar") {
            val resta = nro1 - nro2
            val resu = resta.toString()
            tv1.setText(resu)
        } else if (selec == "multiplicar") {
            val multi = nro1 * nro2
            val resu = multi.toString()
            tv1.text = (resu)
        } else if (selec == "dividir") {
            val divi = nro1 / nro2
            val resu = divi.toString()
            tv1.setText(resu)
        }
    }

}
