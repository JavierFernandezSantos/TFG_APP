package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import apiResult.Match;
import apiResult.Result;
import apiResult.ResultService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrowseActivity extends AppCompatActivity {

    ListadoAdapter adapter;
    ArrayList<ArrayList<String>> info = new ArrayList<>();
    EditText eJornada;
    Button btnBuscar, btnTienda, btnQuiz, btnPerfil;
    TextView tvUsuario, tvPuntos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListadoAdapter(this);

        eJornada = findViewById(R.id.txtJornada);
        btnBuscar = findViewById(R.id.btnBuscar);
        tvUsuario = findViewById(R.id.tvUsuarioBrowse);
        tvPuntos = findViewById(R.id.tvPuntosBrowse);

        Bundle datos = getIntent().getExtras();
        tvUsuario.setText(datos.getString("nombre") + " " + datos.getString("apellidos"));
        tvPuntos.setText(datos.getString("puntos"));


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(eJornada.getText().toString());
            }
        });

        recyclerView.setAdapter(adapter);

        btnTienda = findViewById(R.id.btnTienda);
        btnTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BrowseActivity.this,TiendaActivity.class);
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
                Intent i2 = new Intent(BrowseActivity.this,QuizActivity.class);
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
                Intent i3 = new Intent(BrowseActivity.this,PerfilActivity.class);
                i3.putExtra("id",datos.getString("id"));
                i3.putExtra("nombre",datos.getString("nombre"));
                i3.putExtra("apellidos",datos.getString("apellidos"));
                i3.putExtra("email",datos.getString("email"));
                i3.putExtra("puntos",datos.getString("puntos"));
                startActivity(i3);
            }
        });
    }

    private void buscar(String jornada) {
        adapter.removeData(info);
        info.removeAll(info);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ResultService servicio = retrofit.create(ResultService.class);

        Call<Result> llamada = servicio.listResult("2c1366a78e494dc8a48173ea02688663",jornada);
        llamada.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                try{
                    if(response.isSuccessful()){
                        Result r = response.body();
                        List<Match> matches = r.getMatches();

                        for(Match m : matches){
                            ArrayList<String> fila = new ArrayList<>();
                            fila.add(m.homeTeam.name);
                            fila.add(m.score.fullTime.homeTeam);
                            fila.add(m.score.fullTime.awayTeam);
                            fila.add(m.awayTeam.name);
                            info.add(fila);
                        }
                        adapter.addData(info);

                    }else{
                        if (response.code() == 400) {
                            Log.d("Error code 400",response.errorBody().string());
                        };
                    }

                }catch(Exception e){
                    Toast.makeText(BrowseActivity.this,e.getMessage(), Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}