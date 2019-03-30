package com.example.menuapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var img1 : ImageButton
    private lateinit var img2 : ImageButton
    private lateinit var img3 : ImageButton
    private lateinit var img4 : ImageButton
    private lateinit var img5 : ImageButton
    private lateinit var img6 : ImageButton
    private lateinit var img7 : ImageButton
    private lateinit var img8 : ImageButton
    private lateinit var img9 : ImageButton
    private lateinit var img10 : ImageButton
    private lateinit var img11 : ImageButton
    private lateinit var img12 : ImageButton
    private lateinit var img13 : ImageButton
    private lateinit var img14 : ImageButton
    private lateinit var img15 : ImageButton
    private lateinit var img16 : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1  = findViewById(R.id.imageButton1)
        img2  = findViewById(R.id.imageButton2)
        img3  = findViewById(R.id.imageButton3)
        img4  = findViewById(R.id.imageButton4)
        img5  = findViewById(R.id.imageButton4)
        img6  = findViewById(R.id.imageButton5)
        img7  = findViewById(R.id.imageButton6)
        img8  = findViewById(R.id.imageButton7)
        img9  = findViewById(R.id.imageButton8)
        img10 = findViewById(R.id.imageButton9)
        img11 = findViewById(R.id.imageButton10)
        img12 = findViewById(R.id.imageButton11)
        img13 = findViewById(R.id.imageButton12)
        img14 = findViewById(R.id.imageButton13)
        img15 = findViewById(R.id.imageButton14)
        img16 = findViewById(R.id.imageButton15)

    }


    fun isEqualImage(imgA :ImageButton , imgB : ImageButton):Boolean{
        var bitmap = BitmapFactory.decodeResource(resources,R.drawable.interrogation_icon)


        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId?.toInt()
        if (id == (R.id.opc1)) {
            showMessage("Opcion uno")
        }else if (id == (R.id.opc3)) {
            showMessage("Opcion tres")
        }
        return super.onOptionsItemSelected(item)
    }


    private fun showMessage(msj : String){
        val notification = Toast.makeText(this,msj,Toast.LENGTH_SHORT)
        notification.show()
    }

}
