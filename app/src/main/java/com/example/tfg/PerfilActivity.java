package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PerfilActivity extends AppCompatActivity {

    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //VARIABLES
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);


        //CERRAR SESION Y NAVEGAR A PANTALLA DE INICIO DE SESIÓN
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

    }
}