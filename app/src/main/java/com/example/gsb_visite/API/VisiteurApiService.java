package com.example.gsb_visite.API;

import com.example.gsb_visite.Model.Visiteur;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VisiteurApiService {

    @GET("visiteurs/{id}")
    Call<Visiteur> getVisiteur(@Path("id") String id);

    @POST("visiteurs/login")
    Call<Visiteur> login(@Body Map<String, String> credentials);
}