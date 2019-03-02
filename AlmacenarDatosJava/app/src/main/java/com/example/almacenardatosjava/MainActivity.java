package com.example.almacenardatosjava;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText dateText;
    private String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }

    public void grabar(View v) {
        try {
            dateText = (EditText)findViewById(R.id.editText);
            et1=(EditText)findViewById(R.id.editText3);
            fileName = dateText.getText().toString().replaceAll("/","-");
            String[] archivos = fileList();

                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                        fileName, Activity.MODE_PRIVATE));
                archivo.write(et1.getText().toString());
                archivo.flush();
                archivo.close();

        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "Los datos fueron grabados",
                Toast.LENGTH_SHORT);
        t.show();
        //finish();
    }

    public void leer (View v){

        dateText = (EditText)findViewById(R.id.editText);
        et1=(EditText)findViewById(R.id.editText3);
        String[] archivos = fileList();

        fileName =  "02-03-2019";
        fileName = "".equals(dateText.getText().toString()) ?
                fileName :dateText.getText().toString().replaceAll("/","-") ;

        if (existe(archivos, fileName))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput(fileName));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et1.setText(todo);
            } catch (IOException e) {
            }

    }
}
