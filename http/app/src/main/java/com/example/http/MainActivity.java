package com.example.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private EditText nombre;
    private EditText telefono;

    private static final String REST_SERVICE = "https://spydata.herokuapp.com/";
    private static final String REST_SAVE = REST_SERVICE + "save?";
    private static final String REST_QUERY = REST_SERVICE + "rest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        nombre = findViewById(R.id.editText);
        telefono = findViewById(R.id.editText3);
        listView = findViewById(R.id.listview);


        actualizarList();

    }


    public void guardar(View view) {

        RequestQueue queue = Volley.newRequestQueue(this);


        String nombreString = nombre.getText().toString();
        String telefonoString = telefono.getText().toString();

        String requestString = new StringBuilder()
                .append(REST_SAVE).append("message=")
                .append(nombreString)
                .append("&computer=")
                .append(telefonoString).toString();


        StringRequest request = new StringRequest(Request.Method.POST, requestString,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        actualizarList();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.super.getApplication(),error.getMessage(),Toast.LENGTH_SHORT);


            }
        });

        queue.add(request);
    }

    public  void actualizarList() {

        RequestQueue queue = Volley.newRequestQueue(this);


        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, REST_QUERY,null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray  response) {
                        //TODO llamar servicio rest

                        List<String> listado = new ArrayList<>();

                        for(int a1 = 0 ; a1< response.length();a1++){
                            try {

                                JSONObject o = response.getJSONObject(a1);
                                String name = o.getString("characters");
                                String telefono = o.getString("computer");

                                listado.add(name + " "+telefono);
                            }catch (Exception ex){

                            }
                        }



                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.super.getApplication(), android.R.layout.simple_list_item_1, listado);
                        listView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.super.getApplication(),error.getMessage(),Toast.LENGTH_SHORT);

                    }
                });

        queue.add(jsonObjectRequest);

    }


    private void mwnsaje(String mensaje)
    {

        Toast.makeText(MainActivity.super.getApplication(),mensaje,Toast.LENGTH_SHORT);


    }
}
