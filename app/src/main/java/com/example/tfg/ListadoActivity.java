package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import apiResult.Result;
import apiResult.ResultService;
import apiResult.UsuarioL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoActivity extends AppCompatActivity {


    Button btnhome, btnTienda, btnPerfil;
    TextView tvUsuario, tvPuntos;
    ListadoUsuariosAdapter adapter;
    ArrayList<ArrayList<String>> info = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListadoUsuariosAdapter(this);


        tvUsuario = findViewById(R.id.tvUsuarioBrowse);
        tvPuntos = findViewById(R.id.tvPuntosBrowse);
        Bundle datos = getIntent().getExtras();
        tvUsuario.setText(datos.getString("nombre"));
        tvPuntos.setText(datos.getString("puntos"));

        btnhome = findViewById(R.id.btnHome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListadoActivity.this,BrowseActivity.class);
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
                Intent i2 = new Intent(ListadoActivity.this,TiendaActivity.class);
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
                Intent i3 = new Intent(ListadoActivity.this,PerfilActivity.class);
                i3.putExtra("id",datos.getString("id"));
                i3.putExtra("nombre",datos.getString("nombre"));
                i3.putExtra("apellidos",datos.getString("apellidos"));
                i3.putExtra("email",datos.getString("email"));
                i3.putExtra("puntos",datos.getString("puntos"));
                startActivity(i3);
            }
        });

        recyclerView.setAdapter(adapter);

        //new Peticion().execute();

        new Thread(new Runnable() {
            @Override
            public void run() {
                final String url = "http://192.168.1.32:8080/quizbet/";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ResultService service = retrofit.create(ResultService.class);
                Call<List<UsuarioL>> response = service.listarPorPuntos();

                response.enqueue(new Callback<List<UsuarioL>>() {
                    @Override
                    public void onResponse(Call<List<UsuarioL>> call, Response<List<UsuarioL>> response) {
                        try{
                            List<UsuarioL> usuarios = response.body();
                            for (UsuarioL user : usuarios){
                                ArrayList<String> fila = new ArrayList<>();
                                fila.add(user.getNombre());
                                fila.add(user.getApellido());
                                fila.add(String.valueOf(user.getPuntos()));
                                info.add(fila);
                            }
                            adapter.addData(info);

                        }catch(Exception e){
                            Toast.makeText(ListadoActivity.this,e.getMessage(), Toast.LENGTH_LONG);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<UsuarioL>> call, Throwable t) {
                        Toast.makeText(ListadoActivity.this,"Error de red", Toast.LENGTH_LONG);
                    }
                });
            }
        }).start();

    }
}