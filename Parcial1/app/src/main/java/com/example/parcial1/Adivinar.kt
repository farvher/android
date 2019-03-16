package com.example.parcial1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.lang.Exception

/**
 *
 * */
class Adivinar : AppCompatActivity() {

    private lateinit var probar : Button
    private lateinit var editText: EditText
    private lateinit var textIntentos: TextView;
    private lateinit var checkBox150: CheckBox
    private lateinit var checkBox1100: CheckBox

    private var random150 : Int = (1..50).random()//numero random entre 1 y 50
    private var random1100 : Int = (1..100).random()// numero random entre 1 y 100

    private var intentos : Int = 0
    private var resultados :String = "resultados2.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivinar)
        probar = findViewById(R.id.button2)
        editText = findViewById(R.id.editText2)
        checkBox150 = findViewById(R.id.checkBox)
        checkBox1100 = findViewById(R.id.checkBox2)
        textIntentos = findViewById(R.id.textView7)
        intentos = 0

    }

    fun generar(v:View){
        random150 = (1..50).random()
        random1100 = (1..100).random()
        mostrarMensaje("Numero aleatorio generado :)")
    }

    fun probar(v: View){
        if(editText.text.isNotBlank()){
            var num = editText.text.toString().toInt();
            if(checkBox150.isChecked){
                validarNumero(num,random150)
            }
            else if (checkBox1100.isChecked){
                validarNumero(num,random1100)
            }else{
                mostrarMensaje("No has seleccionado un rango!")
            }

        }else{
            mostrarMensaje("Debe ingresar un valor!")
        }
    }


    fun validarNumero(num : Int, random : Int){
        if (num == random){
            mostrarMensaje("Felicidades, el numero es el ${num}!!")
            escribirResultados(num,intentos  )
            intentos = 0
            escribirResultados(num,intentos)
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else{
            var mayormenor = if (num <random) "Intenta un numero mayor que ${num}" else "Intenta un numero menor que ${num}"
            mostrarMensaje("Lo siento, ${mayormenor}")
        }
        intentos++
        textIntentos.text = "Intentos : ${intentos.toString()}"
    }

    fun mostrarMensaje(msj : String){
        val notification = Toast.makeText(this,msj,Toast.LENGTH_SHORT)
        notification.show()
    }

    fun escribirResultados(num: Int,intentos :Int ){


        var msj = "Con ${intentos} intentos, se adivino el numero ${num} \n"
        var writer = OutputStreamWriter(openFileOutput(resultados,Activity.MODE_APPEND))
        writer.write(msj)
        writer.flush()
        writer.close()

    }

    fun createResultsFile(){
        if (!fileList().contains(resultados)){
            val sd = File(resultados)
            sd.mkdir()
        }

    }
}
