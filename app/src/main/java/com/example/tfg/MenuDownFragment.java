package com.example.tfg;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class MenuDownFragment extends Fragment {

    private Button btnHome, btnFavoritos, btnQuiz, btnPerfil;

    public MenuDownFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu_down, container, false);

        btnHome = v.findViewById(R.id.btnHome);
        btnFavoritos = v.findViewById(R.id.btnTienda);
        btnQuiz = v.findViewById(R.id.btnQuiz);
        btnPerfil = v.findViewById(R.id.btnPerfil);

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getContext(),BrowseActivity.class);
                startActivity(i);
            }
        });

        btnFavoritos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i2 = new Intent(getContext(),TiendaActivity.class);
                startActivity(i2);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i2 = new Intent(getContext(),TiendaActivity.class);
                startActivity(i2);
            }
        });

        btnFavoritos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i3 = new Intent(getContext(),QuizActivity.class);
                startActivity(i3);
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i4 = new Intent(getContext(),PerfilActivity.class);
                startActivity(i4);
            }
        });

        return v;
    }
}