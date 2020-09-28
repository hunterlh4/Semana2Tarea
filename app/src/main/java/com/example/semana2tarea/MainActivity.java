package com.example.semana2tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_PIC_REQUEST = 1;
    EditText nombre,apellido,edad,sexo,direccion;
    ImageView imagen;
    ImageView foto;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre   =(EditText) findViewById(R.id.et_nombre);
        apellido =(EditText) findViewById(R.id.et_apellido);
        edad     =(EditText) findViewById(R.id.et_edad);
        sexo     =(EditText) findViewById(R.id.et_sexo);
        direccion=(EditText) findViewById(R.id.et_direccion);
        imagen   =(ImageView) findViewById(R.id.et_foto);

        //CAPTURAR FOTO
        Button btn_camera = (Button)findViewById(R.id.btn_camara);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
            }
        });



        //enviar
        Button btn_enviar = (Button)findViewById(R.id.btn_enviar);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),MainActivity2.class);

                i.putExtra("nombre",nombre.getText().toString());
                i.putExtra("apellido",apellido.getText().toString());
                i.putExtra("edad",edad.getText().toString());
                i.putExtra("sexo",sexo.getText().toString());
                i.putExtra("direccion",direccion.getText().toString());

                i.putExtra("imageData", bitmap);
                i.setType("/");
                startActivity(i);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_PIC_REQUEST){
            if(resultCode == RESULT_OK){
                 bitmap = (Bitmap)data.getExtras().get("data");
                 foto = (ImageView)findViewById(R.id.et_foto);
                foto.setImageBitmap(bitmap);
            }
        }
    }






}