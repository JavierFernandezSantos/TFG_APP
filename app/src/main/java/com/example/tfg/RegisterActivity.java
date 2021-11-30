package com.example.tfg;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import apiResult.ResultService;
import apiResult.Sesion;
import apiResult.Usuario;
import apiResult.UsuarioL;
import apiResult.UsuarioRegistro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity{

    TextView tvIniciaSesion;
    Button btnRegistrar;
    UsuarioL user;
    EditText etEmail, etPassword, etFecha, etNombre, etApellidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvIniciaSesion = (TextView) findViewById(R.id.tvIniciaSesion);
        tvIniciaSesion.setPaintFlags(tvIniciaSesion.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvIniciaSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        etEmail = findViewById(R.id.etEmail2);
        etPassword = findViewById(R.id.etPassWord2);
        etFecha = findViewById(R.id.etFechaNacimiento);
        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);


        btnRegistrar = findViewById(R.id.btnCrearCuenta);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void registrar() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        LocalDate fechaNacimiento = LocalDate.parse(etFecha.getText().toString());
        String nombre = etNombre.getText().toString().trim();
        String apellidos = etApellidos.getText().toString();

        if(email.isEmpty()){
            etEmail.setError("Email is requiered");
            etEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            etPassword.setError("Password is requiered");
            etPassword.requestFocus();
            return;
        }

        user = new UsuarioL(nombre, apellidos, fechaNacimiento, new Sesion(email, password, "USUARIO") {
        });


                final String url = "http://192.168.1.32:8080/quizbet/";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ResultService service = retrofit.create(ResultService.class);
                Call<UsuarioL> response = service.insertarUsuario(user);

                response.enqueue(new Callback<UsuarioL>() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onResponse(Call<UsuarioL> call, Response<UsuarioL> response) {
                        try{
                            if(response.isSuccessful()){
                                Log.d("RESPUESTA","BIEEEEEEN");
                                //Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ",new GsonBuilder().setPrettyPrinting().create().toJson(response));

                            }else{
                                Log.d("RESPUESTA","MAAAAAAL");
                                Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ",new GsonBuilder().setPrettyPrinting().create().toJson(response));

                            }

                        }catch(Exception e){
                            Toast.makeText(RegisterActivity.this,e.getMessage(), Toast.LENGTH_LONG);
                        }
                    }

                    @Override
                    public void onFailure(Call<UsuarioL> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this,"Error de red", Toast.LENGTH_LONG);
                    }
                });

    }
}