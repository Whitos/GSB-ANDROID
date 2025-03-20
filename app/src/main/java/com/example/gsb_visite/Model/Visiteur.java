package com.example.gsb_visite.Model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class Visiteur {

    @SerializedName("nom")
    private String nom;

    @SerializedName("prenom")
    private String prenom;

    @SerializedName("tel")
    private String tel;

    @SerializedName("email")
    private String email;

    @SerializedName("date_embauche")
    private Date dateEmbauche;

    @SerializedName("visites")
    private List<String> visites;

    @SerializedName("userId")
    private String userId;

    @SerializedName("token")
    private String token;

}