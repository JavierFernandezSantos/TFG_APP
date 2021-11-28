package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    private Button btnCerrarSesion;

    Button btnhome, btnQuiz, btnTienda;
    TextView tvInfoCorreo, tvInfoNombre, tvInfoApellidos, tvInfoPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //VARIABLES
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        tvInfoCorreo = findViewById(R.id.tvInfoCorreo);
        tvInfoNombre = findViewById(R.id.tvInfoNombre);
        tvInfoApellidos = findViewById(R.id.tvInfoApellidos);
        tvInfoPuntos = findViewById(R.id.tvInfoPuntos);

        Bundle datos = getIntent().getExtras();

        tvInfoCorreo.setText(datos.getString("email"));
        tvInfoNombre.setText(datos.getString("nombre"));
        tvInfoApellidos.setText(datos.getString("apellidos"));
        tvInfoPuntos.setText(datos.getString("puntos"));


        //CERRAR SESION Y NAVEGAR A PANTALLA DE INICIO DE SESIÓN
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        btnhome = findViewById(R.id.btnHome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilActivity.this,BrowseActivity.class);
                i.putExtra("id",datos.getString("id"));
                i.putExtra("nombre",datos.getString("nombre"));
                i.putExtra("apellidos",datos.getString("apellidos"));
                i.putExtra("email",datos.getString("email"));
                i.putExtra("puntos",datos.getString("puntos"));
                startActivity(i);
            }
        });

        btnTienda = findViewById(R.id.btnTienda);
        btnTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(PerfilActivity.this,TiendaActivity.class);
                i2.putExtra("id",datos.getString("id"));
                i2.putExtra("nombre",datos.getString("nombre"));
                i2.putExtra("apellidos",datos.getString("apellidos"));
                i2.putExtra("email",datos.getString("email"));
                i2.putExtra("puntos",datos.getString("puntos"));
                startActivity(i2);
            }
        });

        btnQuiz = findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(PerfilActivity.this,QuizActivity.class);
                i3.putExtra("id",datos.getString("id"));
                i3.putExtra("nombre",datos.getString("nombre"));
                i3.putExtra("apellidos",datos.getString("apellidos"));
                i3.putExtra("email",datos.getString("email"));
                i3.putExtra("puntos",datos.getString("puntos"));
                startActivity(i3);
            }
        });

    }
}