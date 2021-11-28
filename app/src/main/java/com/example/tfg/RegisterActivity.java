package com.example.tfg;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

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

import java.time.LocalDate;

import apiResult.ResultService;
import apiResult.Usuario;
import apiResult.UsuarioRegistro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity{

    TextView tvIniciaSesion;
    Button btnRegistrar;
    UsuarioRegistro user;
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

        user = new UsuarioRegistro(email,password,fechaNacimiento,nombre,apellidos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.32:8080/quizbet/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ResultService servicio = retrofit.create(ResultService.class);

        Call<UsuarioRegistro> call = servicio.insertarUsuario(user);
        call.enqueue(new Callback<UsuarioRegistro>() {
            @Override
            public void onResponse(Call<UsuarioRegistro> call, Response<UsuarioRegistro> response) {
                Toast.makeText(getApplicationContext(), "Bien hecho", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UsuarioRegistro> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fatal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}