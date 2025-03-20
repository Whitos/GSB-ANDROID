package com.example.gsb_visite.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsb_visite.API.RetrofitClientInstance;
import com.example.gsb_visite.API.VisiteurApiService;
import com.example.gsb_visite.Model.Visiteur;
import com.example.gsb_visite.databinding.ActivityHomeBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private String userId;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Récupérer les données de l'intent
        Intent intent = getIntent();
        userId = intent.getStringExtra("userId");
        token = intent.getStringExtra("token");

        // Configurer l'interface utilisateur
        setupUI();
    }

    private void setupUI() {
        // Afficher les données de base
        binding.tvWelcome.setText("ID: " + userId + "\nToken: " + token);

        // Récupérer les détails de l'utilisateur depuis l'API si nécessaire
        if (userId != null && !userId.isEmpty()) {
            VisiteurApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(VisiteurApiService.class);
            Call<Visiteur> call = apiService.getVisiteur(userId);
            call.enqueue(new Callback<Visiteur>() {
                @Override
                public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Visiteur visiteur = response.body();
                        binding.tvWelcome.setText("Bienvenue " +
                                "\nID: " + userId +
                                "\nToken: " + token);
                    }
                }

                @Override
                public void onFailure(Call<Visiteur> call, Throwable t) {
                    Toast.makeText(HomeActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}