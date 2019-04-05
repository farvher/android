package com.example.menuapp

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.SoundEffectConstants
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

/**
 * @author farith sanmiguel
 * https://github.com/farvher
 * */
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


    private lateinit var audioManager :AudioManager
    private var oportunity = 0;
    private val gameMap = mutableMapOf<Int, Int>()


    private val images = mutableListOf(

        R.drawable.pikachu,
        R.drawable.bulbasaur,
        R.drawable.charmander,
        R.drawable.jigglypuff,
        R.drawable.meowth,
        R.drawable.psyduck,
        R.drawable.snorlax,
        R.drawable.squirtle
    )
    private var buttonsList = mutableListOf<ImageButton>()

    private val buttons = mutableListOf(
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
    private var selectedMap = mutableMapOf(
        R.id.imageButton1 to false,
        R.id.imageButton2 to false,
        R.id.imageButton3 to false,
        R.id.imageButton4 to false,
        R.id.imageButton5 to false,
        R.id.imageButton6 to false,
        R.id.imageButton7 to false,
        R.id.imageButton8 to false,
        R.id.imageButton9 to false,
        R.id.imageButton10 to false,
        R.id.imageButton11 to false,
        R.id.imageButton12 to false,
        R.id.imageButton13 to false,
        R.id.imageButton14 to false,
        R.id.imageButton15 to false,
        R.id.imageButton16 to false
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

        buttonsList = mutableListOf(
            img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16
        )

        //inicializa la matriz
        setRandonImages()
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager


        img1.setOnClickListener {
            clickImageButton(img1)
        }
        img2.setOnClickListener {
            clickImageButton(img2)
        }
        img3.setOnClickListener {
            clickImageButton(img3)
        }
        img4.setOnClickListener {
            clickImageButton(img4)
        }
        img5.setOnClickListener {
            clickImageButton(img5)
        }
        img6.setOnClickListener {
            clickImageButton(img6)
        }
        img7.setOnClickListener {
            clickImageButton(img7)
        }
        img8.setOnClickListener {
            clickImageButton(img8)
        }
        img9.setOnClickListener {
            clickImageButton(img9)
        }
        img10.setOnClickListener {
            clickImageButton(img10)
        }
        img11.setOnClickListener {
            clickImageButton(img11)
        }
        img12.setOnClickListener {
            clickImageButton(img12)
        }
        img13.setOnClickListener {
            clickImageButton(img13)
        }
        img14.setOnClickListener {
            clickImageButton(img14)
        }
        img15.setOnClickListener {
            clickImageButton(img15)
        }
        img16.setOnClickListener {
            clickImageButton(img16)
        }

    }

    /**
     * Desaparece las imagenes que se han seleccionado y son iguales
     * */
    private fun dissapearImg(img: Int) {
        var selected = gameMap.filter { entry -> selectedMap[entry.key]!! }.toMap()//todos los seleccionados
        selected = selected.filter { entry -> selected.values.groupingBy { it }.eachCount()[entry.value] == 2 }
        if (selected.size >= 2) {
            buttonsList
                .filter { selected.containsKey(it.id) } //filtrar button por seleccionados
                .forEach { it ->
                    it.setBackgroundColor(Color.RED)
                    it.isClickable = false
                    }
        }
    }

    /**
     * eventos al dar click en una imagen
     * resta y suma oportunidades
     * */
    private fun clickImageButton(imgButton: ImageButton): Boolean {
        if (!selectedMap.get(imgButton.id)!!) {
            var img = openPokeBall(imgButton)
            dissapearImg(img!!)
            if (oportunity == 2) {
                resetAllImageButton()
            } else {
                oportunity++
            }

        } else {
            setDefaultImg(imgButton)
            oportunity--

            selectedMap.replace(imgButton.id, false)
        }
        if(buttonsList.all {  !it.isClickable }){
            showMessage("Felicidades ganaste!!")
        }
        return true
    }

    /**
     * Cambia la imagen del boton por el pokemon
     * */
    private fun openPokeBall(imgButton: ImageButton): Int? {
        var img = gameMap[imgButton.id]
        var bitmap = BitmapFactory.decodeResource(resources, img!!)
        imgButton.setImageBitmap(bitmap)
        selectedMap.replace(imgButton.id, true)
        return img
    }

    /**
     * inicializa los 16 botones con 16 imagenes aleatoriamente
     * */
    private fun setRandonImages() {
        buttons.shuffle()
        images.addAll(images)
        var a = 0
        for (b: Int in buttons) {
            gameMap.put(b, images[a++])
        }
    }

    /**
     * coloca la imagen default - la pokeball
     * */
    private fun setDefaultImg(vararg imagenButton: ImageButton) {
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.pokeball)
        imagenButton.filter { it-> it.isClickable}.forEach { imageButton -> imageButton.setImageBitmap(bitmap) }
    }

    /**
     * reinicia todas las imagenes no deshabilitadas
     * */
    private fun resetAllImageButton() {

        setDefaultImg(
            img1,
            img2,
            img3,
            img4,
            img5,
            img6,
            img7,
            img8,
            img9,
            img10,
            img11,
            img12,
            img13,
            img14,
            img15,
            img16
        )
        oportunity = 0
        selectedMap.replaceAll { t, u -> false }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId?.toInt()
        if (id == (R.id.opc1)) {
            restartActivity()

        } else if (id == (R.id.opc3)) {
            val intent = Intent(this,About::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


    /**
     * reinicia el juego
     *
     * */
    private fun restartActivity() {
        var intent = getIntent()
        overridePendingTransition(0, 0)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        overridePendingTransition(0, 0)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }


    /**
     * muestra un mensaje toast
     **/
    private fun showMessage(msj: String) {
        val notification = Toast.makeText(this, msj, Toast.LENGTH_LONG)
        notification.show()
    }

}
