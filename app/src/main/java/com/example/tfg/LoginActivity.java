package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView tvRegistrate, tvOlvidadoContraseña;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VARIABLES
        tvRegistrate = (TextView) findViewById(R.id.tvRegistrate);
        tvOlvidadoContraseña = (TextView) findViewById(R.id.tvOlvidadoContraseña);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        //ACCEDER A LA APP
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,BrowseActivity.class);
                startActivity(i);
            }
        });


        //CAMBIAR A ACTIVIDAD DE REGISTRARSE
        tvRegistrate.setPaintFlags(tvRegistrate.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i2);
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