package com.example.app2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Acercade : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acercade)
    }

    fun salir(v :View) : Unit{

        finish();
    }
}
