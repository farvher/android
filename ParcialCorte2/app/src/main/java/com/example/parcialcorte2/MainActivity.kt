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

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery("select id from usuarios where " +
                "name = '${nickname.text.toString()}' and clave = '${password.text.toString()}' ", null)
        if (fila.moveToFirst()){
            //TODO VALIDAR si el usuario existe

           var idUser  = fila.getInt(0)
            if(mostrarFrase.isChecked){
                var intent = Intent(this,VerFrases::class.java)
                intent.putExtra("nick",nickname.text.toString())
                intent.putExtra("idUser",idUser)
                startActivity(intent)
            } else if (guardarFrase.isChecked){
                var intent = Intent(this,GuardarFrases::class.java)
                intent.putExtra("nick",nickname.text.toString())
                intent.putExtra("idUser",idUser)
                startActivity(intent)
            }

        }else{
            showMessage("Usuario no existe!")

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
