package com.example.emptyap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var et1 : EditText

    private lateinit var et2 : EditText

    private lateinit var tv1  : TextView

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1 = findViewById(R.id.editText3)
        et2 = findViewById(R.id.editText4)
        tv1 = findViewById(R.id.textView3)
        button = findViewById(R.id.button3)

        button.setOnClickListener{
            if (!et1.text.isEmpty() && !et2.text.isEmpty()){

                var result = et1.text.toString().toLong() +  et2.text.toString().toLong()
                tv1.text = result.toString()
            }

        }

    }

    public fun sum () : Unit {

        val a  : Int = Integer.parseInt(et1.text.toString())
        val b : Int = Integer.parseInt(et2.text.toString())

        val results = a + b

        tv1.text = results.toString()

    }
}
