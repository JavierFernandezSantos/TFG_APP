package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView tvRegistrate, tvOlvidadoContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VARIABLES
        tvRegistrate = (TextView) findViewById(R.id.tvRegistrate);
        tvOlvidadoContraseña = (TextView) findViewById(R.id.tvOlvidadoContraseña) ;


        //CAMBIAR A ACTIVIDAD DE REGISTRARSE
        tvRegistrate.setPaintFlags(tvRegistrate.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        //ENVIAR CORREO ELECTRONICO CON LOS CREDENCIALES DEL USUARIO
        tvOlvidadoContraseña.setPaintFlags(tvOlvidadoContraseña.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvOlvidadoContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Enviaremos un correo electrónico con tus credenciales!", Toast.LENGTH_LONG).show();
            }
        });


    }
}