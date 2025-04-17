package com.example.gsb_visite.API;


import com.example.gsb_visite.Model.Praticien;
import com.example.gsb_visite.Model.Visiteur;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VisiteurApiService {

    @GET("visiteurs/{id}")
    Call<Visiteur> getVisiteur(@Header ("Authorization") String autorization, @Path("id") String id);

    @POST("visiteurs/login")
    Call<Visiteur> login(@Body Map<String, String> credentials);

    @GET("practiciens")
    Call<ArrayList<Praticien>> getPraticiens(@Header ("Authorization") String autorization);

    @GET("practiciens/{id}")
    Call<Praticien> getPraticien(@Header("Authorization") String authorization, @Path("id") String id);

    @GET("visiteurs/{id}/praticiens")
    Call<ArrayList<Praticien>> getPraticiensPortefeuille(@Header("Authorization") String authorization, @Path("id") String id);
}