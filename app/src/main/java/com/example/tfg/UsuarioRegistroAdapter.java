package com.example.tfg;

import apiResult.ResultService;
import apiResult.UsuarioRegistro;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioRegistroAdapter {
    public static final String BASE_URL = "http://192.168.1.32:8080/quizbet/";
    private Retrofit retrofit;

    private UsuarioRegistroAdapter(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ResultService getApi(){
        return retrofit.create(ResultService.class);
    }
}
