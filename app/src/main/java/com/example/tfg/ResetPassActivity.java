package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import apiResult.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPassActivity extends AppCompatActivity implements Callback<Usuario> {

    EditText tvEmailUsuarioAEnviar, txtCodigoPorEmail,txtEmailResetPass2,txtPassNueva;
    Button btResetPass, btNuevaPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        tvEmailUsuarioAEnviar=findViewById(R.id.tvEmailResetPass);
        btResetPass=findViewById(R.id.btEnviarEmailUsuario);

        txtCodigoPorEmail=findViewById(R.id.txtCodigoPorEmail);
        txtEmailResetPass2=findViewById(R.id.tvEmailResetPass2);
        txtPassNueva=findViewById(R.id.txtNuevaPass);
        btNuevaPass=findViewById(R.id.btCambiarPass);

        btResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarEmail(tvEmailUsuarioAEnviar.getText().toString());
            }
        });

        btNuevaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarContrasenia(txtCodigoPorEmail.getText().toString(),txtEmailResetPass2.getText().toString(),txtPassNueva.getText().toString());
            }
        });

    }

    public void enviarEmail(String email){

        Call<Usuario> call=UsuarioAdapter.getApiService().cambiarPass(email);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Usuario> call, Response<Usuario> response) {

        if(response.isSuccessful()){
            Toast.makeText(getApplicationContext(), "Enviado/actualizado correctamente", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "No existe un usuario con este correo", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<Usuario> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "Error de red", Toast.LENGTH_LONG).show();
    }

    public void cambiarContrasenia(String codigo,String email,String pass){
        Call<Usuario> call=UsuarioAdapter.getApiService().cambiarContrasenia(codigo,email,pass);
        call.enqueue(this);

    }
}