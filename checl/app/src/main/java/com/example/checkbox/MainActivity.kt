package com.example.checkbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var checkBoxSuma: CheckBox
    private lateinit var checkBoxResta: CheckBox
    private lateinit var button: Button
    private lateinit var textView: TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1 = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)
        checkBoxSuma = findViewById(R.id.checkBox)
        checkBoxResta = findViewById(R.id.checkBox2)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView3)
        button.setOnClickListener {
            if(editText.text.isNotBlank() && editText2.text.isNotBlank()) operar()
        }

    }


    fun operar() {

        if(checkBoxSuma.isChecked)  textView.text = "La suma es : ${editText.text.toString().toInt() + editText2.text.toString().toInt()}"
        else if (checkBoxResta.isChecked) textView.text ="La resta es : ${editText.text.toString().toInt() - editText2.text.toString().toInt()}"
        else textView.text = "Seleccione una operacion"
    }
}
