package com.facci.camarasv;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivitySV extends AppCompatActivity {

    Bitmap bmp;
    ImageView imagen;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_sv);
        boton = (Button) findViewById(R.id.boton_tomarfoto);
        imagen = (ImageView)findViewById(R.id.imagen);

        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(llamar, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            bmp = (Bitmap)ext.get("data");
            imagen.setImageBitmap(bmp);
        }
    }
}
