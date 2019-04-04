package com.example.menuapp

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
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

        img1.setOnTouchListener { v, event ->
            clickImageButton(img1)
        }
        img2.setOnTouchListener { v, event ->
            clickImageButton(img2)
        }
        img3.setOnTouchListener { v, event ->
            clickImageButton(img3)
        }
        img4.setOnTouchListener { v, event ->
            clickImageButton(img4)
        }
        img5.setOnTouchListener { v, event ->
            clickImageButton(img5)
        }
        img6.setOnTouchListener { v, event ->
            clickImageButton(img6)
        }
        img7.setOnTouchListener { v, event ->
            clickImageButton(img7)
        }
        img8.setOnTouchListener { v, event ->
            clickImageButton(img8)
        }
        img9.setOnTouchListener { v, event ->
            clickImageButton(img9)
        }
        img10.setOnTouchListener { v, event ->
            clickImageButton(img10)
        }
        img11.setOnTouchListener { v, event ->
            clickImageButton(img11)
        }
        img12.setOnTouchListener { v, event ->
            clickImageButton(img12)
        }
        img13.setOnTouchListener { v, event ->
            clickImageButton(img13)
        }
        img14.setOnTouchListener { v, event ->
            clickImageButton(img14)
        }
        img15.setOnTouchListener { v, event ->
            clickImageButton(img15)
        }
        img16.setOnTouchListener { v, event ->
            clickImageButton(img16)
        }

    }

    private fun dissapearImg(img: Int) {
        var selected = gameMap.filter { entry -> selectedMap[entry.key]!! }.toMap()//todos los seleccionados
        selected = selected.filter { entry -> selected.values.groupingBy { it }.eachCount()[entry.value] == 2 }
        if (selected.size >= 2) {
            buttonsList
                .filter { selected.containsKey(it.id) } //filtrar button por seleccionados
                .forEach { it.visibility = View.INVISIBLE }
        }
    }

    private fun clickImageButton(imgButton: ImageButton) :Boolean{
        if (!selectedMap.get(imgButton.id)!!) {
            var img = gameMap[imgButton.id]
            var bitmap = BitmapFactory.decodeResource(resources, img!!)
            imgButton.setImageBitmap(bitmap)
            selectedMap.replace(imgButton.id, true)
            dissapearImg(img)
            if (oportunity == 1) {

                resetAllImageButton()
            } else {
                oportunity++
            }

        } else {
            setDefaultImg(imgButton)
            oportunity--

            selectedMap.replace(imgButton.id, false)
        }
        return true
    }

    private fun setRandonImages() {
        buttons.shuffle()
        images.addAll(images)
        var a = 0
        for (b: Int in buttons) {
            gameMap.put(b, images[a++])
        }
    }

    private fun setDefaultImg(vararg imagenButton: ImageButton) {
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.pokeball)
        imagenButton.forEach { imageButton -> imageButton.setImageBitmap(bitmap) }
    }

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
            showMessage("Opcion tres")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun restartActivity() {
        var intent = getIntent()
        overridePendingTransition(0, 0)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        overridePendingTransition(0, 0)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }


    private fun showMessage(msj: String) {
        val notification = Toast.makeText(this, msj, Toast.LENGTH_SHORT)
        notification.show()
    }

}
