package com.example.menuapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    private lateinit var img1: ImageButton
    private lateinit var img2: ImageButton
    private lateinit var img3: ImageButton
    private lateinit var img4: ImageButton
    private lateinit var img5: ImageButton
    private lateinit var img6: ImageButton
    private lateinit var img7: ImageButton
    private lateinit var img8: ImageButton
    private lateinit var img9: ImageButton
    private lateinit var img10: ImageButton
    private lateinit var img11: ImageButton
    private lateinit var img12: ImageButton
    private lateinit var img13: ImageButton
    private lateinit var img14: ImageButton
    private lateinit var img15: ImageButton
    private lateinit var img16: ImageButton

    private val gameMap = mutableMapOf<Int, Int>()

    private lateinit var listButtons;


    val images = mutableListOf<Int>(

        R.drawable.pikachu,
        R.drawable.bulbasaur,
        R.drawable.charmander,
        R.drawable.jigglypuff,
        R.drawable.meowth,
        R.drawable.psyduck,
        R.drawable.snorlax,
        R.drawable.squirtle
    )

    val buttons = mutableListOf<Int>(
        R.id.imageButton1,
        R.id.imageButton2,
        R.id.imageButton3,
        R.id.imageButton4,
        R.id.imageButton5,
        R.id.imageButton6,
        R.id.imageButton7,
        R.id.imageButton8,
        R.id.imageButton9,
        R.id.imageButton10,
        R.id.imageButton11,
        R.id.imageButton12,
        R.id.imageButton13,
        R.id.imageButton14,
        R.id.imageButton15,
        R.id.imageButton16
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1 = findViewById(R.id.imageButton1)
        img2 = findViewById(R.id.imageButton2)
        img3 = findViewById(R.id.imageButton3)
        img4 = findViewById(R.id.imageButton4)
        img5 = findViewById(R.id.imageButton5)
        img6 = findViewById(R.id.imageButton6)
        img7 = findViewById(R.id.imageButton7)
        img8 = findViewById(R.id.imageButton8)
        img9 = findViewById(R.id.imageButton9)
        img10 = findViewById(R.id.imageButton10)
        img11 = findViewById(R.id.imageButton11)
        img12 = findViewById(R.id.imageButton12)
        img13 = findViewById(R.id.imageButton13)
        img14 = findViewById(R.id.imageButton14)
        img15 = findViewById(R.id.imageButton15)
        img16 = findViewById(R.id.imageButton16)

        listButtons =

        //inicializa la matriz
        setRandonImages();

        img1.setOnClickListener { v ->
            setMapImage(R.id.imageButton1,img1)
        }
        img2.setOnClickListener { v ->
            setMapImage(R.id.imageButton2,img2)
        }
        img3.setOnClickListener { v ->
            setMapImage(R.id.imageButton3,img3)
        }
        img4.setOnClickListener { v ->
            setMapImage(R.id.imageButton4,img4)
        }
        img5.setOnClickListener { v ->
            setMapImage(R.id.imageButton5,img5)
        }
        img6.setOnClickListener { v ->
            setMapImage(R.id.imageButton6,img6)
        }
        img7.setOnClickListener { v ->
            setMapImage(R.id.imageButton7,img7)
        }
        img8.setOnClickListener { v ->
            setMapImage(R.id.imageButton8,img8)
        }
        img9.setOnClickListener { v ->
            setMapImage(R.id.imageButton9,img9)
        }
        img10.setOnClickListener { v ->
            setMapImage(R.id.imageButton10,img10)
        }
        img11.setOnClickListener { v ->
            setMapImage(R.id.imageButton11,img11)
        }
        img12.setOnClickListener { v ->
            setMapImage(R.id.imageButton12,img12)
        }
        img13.setOnClickListener { v ->
            setMapImage(R.id.imageButton13,img13)
        }
        img14.setOnClickListener { v ->
            setMapImage(R.id.imageButton14,img14)
        }
        img15.setOnClickListener { v ->
            setMapImage(R.id.imageButton15,img15)
        }
        img16.setOnClickListener { v ->
            setMapImage(R.id.imageButton16,img16)
        }

    }


    fun isEqualImage(imgA: ImageButton, imgB: ImageButton): Boolean {
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.interrogation_icon)


        return false
    }

    fun setMapImage(button: Int, imagenButton : ImageButton){
        var img =  gameMap.get(button);
        var bitmap = BitmapFactory.decodeResource(resources,img!!)
        imagenButton.setImageBitmap(bitmap)
    }
    fun setRandonImages() {
        for(b : Int  in buttons){
            var pos = (0..7).random()
            var img = images[pos]
            gameMap.put(b,img)
        }
    }

    fun resetImages(){


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId?.toInt()
        if (id == (R.id.opc1)) {
            showMessage("Opcion uno")
        } else if (id == (R.id.opc3)) {
            showMessage("Opcion tres")
        }
        return super.onOptionsItemSelected(item)
    }


    private fun showMessage(msj: String) {
        val notification = Toast.makeText(this, msj, Toast.LENGTH_SHORT)
        notification.show()
    }

}
