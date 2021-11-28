package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import apiResult.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements Callback<Usuario> {

    TextView tvRegistrate, tvOlvidadoContraseña, tvEmail, tvPass;
    Button btnEnviar;
    Usuario usuarioSesion;
    boolean exito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VARIABLES
        tvRegistrate = (TextView) findViewById(R.id.tvRegistrate);
        tvOlvidadoContraseña = (TextView) findViewById(R.id.tvOlvidadarPass);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        tvEmail=findViewById(R.id.etEmail);
        tvPass=findViewById(R.id.etPass);


        //ACCEDER A LA APP
        pulsarBotonEnviar();


        //CAMBIAR A ACTIVIDAD DE REGISTRARSE
        tvRegistrate.setPaintFlags(tvRegistrate.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i2);
            }
        });

        //ENVIAR CORREO ELECTRONICO CON LOS CREDENCIALES DEL USUARIO
        tvOlvidadoContraseña.setPaintFlags(tvOlvidadoContraseña.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvOlvidadoContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Enviaremos un correo electrónico con tus credenciales!", Toast.LENGTH_LONG).show();
            }
        });

    }
    public void iniciarSesion(String email,String pass){
        Call<Usuario> call=UsuarioAdapter.getApiService().iniciarSesion(email,pass);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
        if(response.isSuccessful()){
            usuarioSesion= response.body();
            Toast.makeText(getApplicationContext(), "Bienvenido " + usuarioSesion.getNombre(), Toast.LENGTH_LONG).show();
            exito=true;
        }
        else {
            exito = false;
        }

        if (exito) {
            Intent i = new Intent(LoginActivity.this, BrowseActivity.class);

            i.putExtra("id",usuarioSesion.getId());
            i.putExtra("nombre",usuarioSesion.getNombre());
            i.putExtra("apellidos",usuarioSesion.getApellidos());
            i.putExtra("email",usuarioSesion.getEmail());
            i.putExtra("puntos",String.valueOf(usuarioSesion.getPuntos()));

            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<Usuario> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "Error de red", Toast.LENGTH_LONG).show();
    }

    public void pulsarBotonEnviar(){
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion(tvEmail.getText().toString(), tvPass.getText().toString());
            }
        });
    }
}