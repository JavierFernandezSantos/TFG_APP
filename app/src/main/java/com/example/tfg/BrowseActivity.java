package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListadoAdapter(this);

        recyclerView.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://api.football-data.org")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ResultService servicio = retrofit.create(ResultService.class);

                Call<Result> llamada = servicio.listResult("2c1366a78e494dc8a48173ea02688663");
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
        }).start();
    }
}