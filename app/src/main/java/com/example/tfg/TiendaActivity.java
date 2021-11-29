package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TiendaActivity extends AppCompatActivity {

    Button btnhome, btnQuiz, btnPerfil;
    TextView tvUsuario, tvPuntos;
    View imgSteam, imgNetflix, imgPlay, imgAmazon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        tvUsuario = findViewById(R.id.tvUsuarioBrowse);
        tvPuntos = findViewById(R.id.tvPuntosBrowse);
        Bundle datos = getIntent().getExtras();
        tvUsuario.setText(datos.getString("nombre") + " " + datos.getString("apellidos"));
        tvPuntos.setText(datos.getString("puntos"));

        btnhome = findViewById(R.id.btnHome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TiendaActivity.this,BrowseActivity.class);
                i.putExtra("id",datos.getString("id"));
                i.putExtra("nombre",datos.getString("nombre"));
                i.putExtra("apellidos",datos.getString("apellidos"));
                i.putExtra("email",datos.getString("email"));
                i.putExtra("puntos",datos.getString("puntos"));
                startActivity(i);
            }
        });

        btnQuiz = findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TiendaActivity.this,QuizActivity.class);
                i2.putExtra("id",datos.getString("id"));
                i2.putExtra("nombre",datos.getString("nombre"));
                i2.putExtra("apellidos",datos.getString("apellidos"));
                i2.putExtra("email",datos.getString("email"));
                i2.putExtra("puntos",datos.getString("puntos"));
                startActivity(i2);
            }
        });

        btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(TiendaActivity.this,PerfilActivity.class);
                i3.putExtra("id",datos.getString("id"));
                i3.putExtra("nombre",datos.getString("nombre"));
                i3.putExtra("apellidos",datos.getString("apellidos"));
                i3.putExtra("email",datos.getString("email"));
                i3.putExtra("puntos",datos.getString("puntos"));
                startActivity(i3);
            }
        });

        imgSteam = findViewById(R.id.steamImg);
        imgPlay = findViewById(R.id.playImg);
        imgNetflix = findViewById(R.id.netflixImg);
        imgAmazon = findViewById(R.id.amazonImg);

        imgSteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgNetflix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgAmazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}