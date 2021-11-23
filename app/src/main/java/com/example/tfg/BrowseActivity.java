package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import apiResult.Result;
import apiResult.ResultService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrowseActivity extends AppCompatActivity {

    ListadoAdapter adapter;
    ArrayList<String> info = new ArrayList<>();

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

                Call<List<Result>> llamada = servicio.listResult();

                llamada.enqueue(new Callback<List<Result>>() {
                    @Override
                    public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                        for(Result r: response.body()){
                            Log.d("Resultado", r.count);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Result>> call, Throwable t) {
                        Log.d("Resultado", "Fallo en la peticion...");
                    }
                });

            }
        }).start();
    }
}