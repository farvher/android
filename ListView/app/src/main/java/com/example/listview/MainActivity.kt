package com.example.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val paises = arrayOf(
        "Argentina",
        "Chile",
        "Paraguay",
        "Bolivia",
        "Peru",
        "Ecuador",
        "Brasil",
        "Colombia",
        "Venezuela",
        "Uruguay"
    )
    private val habitantes = arrayOf(
        "40000000",
        "17000000",
        "6500000",
        "10000000",
        "30000000",
        "14000000",
        "183000000",
        "44000000",
        "29000000",
        "3500000"
    )
    private lateinit var tv1: TextView
    private lateinit var lv1: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById(R.id.textView2)
        lv1 = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)
        lv1.setAdapter(adapter)

        lv1.setOnItemClickListener{parent, view, position, id -> tv1.text =  "Población de ${lv1.selectedItem} es ${habitantes[position]}" }
    }
}
