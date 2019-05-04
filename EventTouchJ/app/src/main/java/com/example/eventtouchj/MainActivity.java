package com.example.eventtouchj;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private int corx, cory;
    private Lienzo fondo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        corx = 100;
        cory = 100;
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        fondo = new Lienzo(this);
        fondo.setOnTouchListener(this);
        layout1.addView(fondo);

    }

    public boolean onTouch(View v, MotionEvent event) {
        corx = (int) event.getX();
        cory = (int) event.getY();
        fondo.invalidate();
        return true;
    }


    class Lienzo extends View {

        private List<Coordenada> cors = new ArrayList<>();


        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 0);
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            pincel1.setStrokeWidth(20);
            pincel1.setStyle(Paint.Style.STROKE);
            cors.add(new Coordenada(corx, cory));
            for (Coordenada c : cors) {
                canvas.drawPoint(c.getX(), c.getY(), pincel1);
            }

            if (cors.size() > 1) {
                canvas.drawLine(cors.get(cors.size() - 2).getX(), cors.get(cors.size() - 2).getY(), corx, cory, pincel1);

            }


        }

    }

    public void exportImg(View v) {
        RelativeLayout view = (RelativeLayout) findViewById(R.id.layout1);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b = view.getDrawingCache();
        File dir =     getFilesDir();
        File root = Environment.getExternalStorageDirectory();
        File output = new File(root.getAbsolutePath()+"/img.jpg");
        OutputStream os = null;

        try {
            os = new FileOutputStream(output);
            b.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();

            //this code will scan the image so that it will appear in your gallery when you open next time
            MediaScannerConnection.scanFile(this, new String[]{output.toString()}, null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        public void onScanCompleted(String path, Uri uri) {

                        }
                    }
            );
        } catch (Exception e) {
            e.getStackTrace();
        }


    }


    public class Coordenada {

        private Integer x;
        private Integer y;

        public Coordenada(Integer x, Integer y) {

            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }


    private String saveToInternalStorage(Bitmap bitmapImage) {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }
}

