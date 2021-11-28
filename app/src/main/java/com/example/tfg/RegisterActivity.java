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

import apiResult.Usuario;
import apiResult.UsuarioRegistro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements Callback<Usuario>{

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

                user = new UsuarioRegistro(etEmail.getText().toString(),
                        etPassword.getText().toString(),
                        LocalDate.parse(etFecha.getText().toString()),
                        etNombre.getText().toString(),
                        etApellidos.getText().toString());

                registrar(user);
            }
        });
    }

    private void registrar(UsuarioRegistro user) {
        Call<Usuario> call=UsuarioAdapter.getApiService().insertarUsuario(user);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
        if(response.isSuccessful()){
            Log.d("AAAAAAAA","aaaaaaaaaaaaaa");
        }
        else {
            Log.d("BBBBBBBBB","bbbbbbbbb");
        }

    }

    @Override
    public void onFailure(Call<Usuario> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "Error de red", Toast.LENGTH_LONG).show();
    }
}