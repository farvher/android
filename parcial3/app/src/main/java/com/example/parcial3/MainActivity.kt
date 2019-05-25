package com.example.parcial3

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.location.LocationManager
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley





class MainActivity : AppCompatActivity() {


    private lateinit var name: EditText
    private lateinit var location: EditText

    private lateinit var butonIni: Button

    private lateinit var butonFin: Button

    private lateinit var guardar: Button

    private var latitude: Int = 0
    private var length: Int = 0

    private var latitude2: Int = 0
    private var length2: Int = 0



    //variable de distancia entre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editText)
        location = findViewById(R.id.editText2)

        butonIni = findViewById(R.id.button)
        butonFin = findViewById(R.id.button2)
        guardar = findViewById(R.id.button3)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1000
            )
        }
        val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val locationA = Location("point A")
        val locationB = Location("point B")

        var nameA = "";
        var lugarA = "";
        var lugarB = "";
        var longitudeA :Double = 0.0
        var latitudeA :Double = 0.0

        butonIni.setOnClickListener {

            nameA = name.text.toString()
            lugarA = location.text.toString()

            val location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0.1f,locationListener)
            longitudeA = location.longitude
            latitudeA = location.latitude
            locationA.setLatitude(longitudeA)
            locationA.setLongitude(latitudeA)

            var cadena = "${longitudeA} ${latitudeA} "
            val notificacion = Toast.makeText(this, cadena, Toast.LENGTH_LONG)
            notificacion.show()

        }

        var longitudeB :Double = 0.0
        var latitudeB :Double = 0.0
        var distance :Float  = Float.MIN_VALUE

        butonFin.setOnClickListener {

            lugarB = location.text.toString();

            val location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0.1f,locationListener)
            longitudeB = location.longitude
            latitudeB = location.latitude

            locationB.setLatitude(longitudeB)
            locationB.setLongitude(latitudeB)

            distance = locationA.distanceTo(locationB)
            var cadena = "${longitudeB} ${latitudeB} distancia ${distance}  "
            val notificacion = Toast.makeText(this, cadena, Toast.LENGTH_LONG)
            notificacion.show()


        }

        guardar.setOnClickListener {

            var cadena = "${nameA} ${lugarA} ${lugarB}  ${latitudeA}  ${longitudeA} ${latitudeB} ${longitudeB} ${distance} ${distance/1000}"
            val notificacion = Toast.makeText(this, cadena, Toast.LENGTH_LONG)
            notificacion.show()

            this.saveAllData(nameA,lugarA,lugarB,latitudeA,longitudeA,latitudeB,longitudeB,distance,distance/1000)
        }


    }


    fun saveAllData(
        name: String, lugarA: String, lugarB: String,
        latitudA: Double, longitudeA: Double, latitudB: Double, longitudeB: Double,
        meters: Float, kilometers: Float
    ) {


        val queue = Volley.newRequestQueue(this)


        val request = object : StringRequest(Request.Method.POST,
            "http://leosan.co.nf/guardarparcial.php",
            Response.Listener {
                val notificacion = Toast.makeText(this, "Enviado", Toast.LENGTH_LONG)
                notificacion.show()
                println("guardado")
                // get response
            }, Response.ErrorListener { e ->
                val notificacion = Toast.makeText(this, "error enviando", Toast.LENGTH_LONG)
                notificacion.show()
            }) {
            public override fun getParams(): Map<String, String> {
                val params = mapOf(
                    "datoA" to name.toString(),
                    "datoB" to lugarA.toString(), "datoC" to latitudA.toString(), "datoD" to longitudeA.toString(),
                    "datoE" to lugarB.toString(), "datoF" to latitudB.toString(), "datoG" to longitudeB.toString(),
                    "datoH" to meters.toString(), "datoI" to kilometers.toString()
                )

                return params
            }
        }
        queue.add(request)
    }



    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {

        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }




}
