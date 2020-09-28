package com.example.semana2tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String nombre,appellido,sexo,edad,direccion,localizacion;
    TextView tvnombre,tvapellido,tvsexo,tvedad,tvdireccion;
    ImageView foto;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvnombre = (TextView) findViewById(R.id.et_nombre);
        tvapellido = (TextView) findViewById(R.id.et_apellido);
        tvsexo = (TextView) findViewById(R.id.et_sexo);
        tvedad = (TextView) findViewById(R.id.et_edad);
        tvdireccion = (TextView) findViewById(R.id.et_direccion);

        Intent i = getIntent();

        nombre = i.getExtras().getString("nombre","");
        appellido = i.getExtras().getString("apellido","");
        sexo = i.getExtras().getString("sexo","");
        edad = i.getExtras().getString("edad","");
        direccion = i.getExtras().getString("direccion","");



        tvnombre.setText(String.valueOf(nombre));
        tvapellido.setText(String.valueOf(appellido));
        tvsexo.setText(String.valueOf(sexo));
        tvedad.setText(String.valueOf(edad));
        tvdireccion.setText(String.valueOf(direccion));

        bitmap = (Bitmap)i.getExtras().get("imageData");
        foto = (ImageView)findViewById(R.id.btn_imagen);
        foto.setImageBitmap(bitmap);


    }


    public void VolverOnClick(View v){

        super.onBackPressed();
    }



}