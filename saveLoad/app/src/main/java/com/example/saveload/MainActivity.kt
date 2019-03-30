package com.example.saveload

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    private lateinit var  saveAction : Button
    private lateinit var  loadByCodAction : Button
    private lateinit var  loadByDescAction : Button
    private lateinit var  deleteByCodAction : Button
    private lateinit var  updateAction : Button
    private lateinit var  exitAction : Button
    private lateinit var clearAction : Button

    private lateinit var cod : EditText;
    private lateinit var desc : EditText
    private lateinit var price : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cod = findViewById(R.id.editText1)
        desc = findViewById(R.id.editText2)
        price = findViewById(R.id.editText3)

        saveAction  = findViewById(R.id.button)

    }
}
