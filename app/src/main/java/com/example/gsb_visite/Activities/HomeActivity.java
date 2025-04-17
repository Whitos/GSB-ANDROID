package com.example.gsb_visite.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gsb_visite.API.RetrofitClientInstance;
import com.example.gsb_visite.API.VisiteurApiService;
import com.example.gsb_visite.Model.Praticien;
import com.example.gsb_visite.Model.Visiteur;
import com.example.gsb_visite.Recyclers.PraticienAdapter;
import com.example.gsb_visite.Recyclers.RecyclerTouchListener;
import com.example.gsb_visite.Recyclers.RecyclerViewClickListener;
import com.example.gsb_visite.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private String userId;
    private String token;
    private PraticienAdapter adapter;
    private List<Praticien> praticienList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Récupérer les données de l'intent
        Intent intent = getIntent();
        userId = intent.getStringExtra("userId");
        token = "Bearer " + intent.getStringExtra("token");

        binding.rvPraticiens.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PraticienAdapter(praticienList);
        binding.rvPraticiens.setAdapter(adapter);

        binding.rvPraticiens.addOnItemTouchListener(new RecyclerTouchListener(this,binding.rvPraticiens, new RecyclerViewClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        // Récupérer le praticien à la position sélectionnée
                        Praticien praticien = praticienList.get(position);

                        // Créer un intent pour ouvrir PraticienInformationsActivity
                        Intent intent = new Intent(HomeActivity.this, PraticienInformationsActivity.class);

                        intent.putExtra("praticien", praticien);
                        intent.putExtra("token", token); // Récupérer le token sans "Bearer "

                        // Démarrer l'activité
                        startActivity(intent);
                    }
                }
        ));
        loadUserInfo();
        loadPraticiensPortefeuille();
    }

    private void loadUserInfo() {

        // Récupérer les détails de l'utilisateur depuis l'API si nécessaire
        if (userId != null && !userId.isEmpty()) {
            VisiteurApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(VisiteurApiService.class);
            Call<Visiteur> call = apiService.getVisiteur(token ,userId);
            call.enqueue(new Callback<Visiteur>() {
                @Override
                public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Visiteur visiteur = response.body();
                        binding.tvBienvenue.setText("Bienvenue " + visiteur.getPrenom() + " " + visiteur.getNom());
                    }
                }

                @Override
                public void onFailure(Call<Visiteur> call, Throwable t) {
                    Toast.makeText(HomeActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void loadPraticiensPortefeuille() {
        VisiteurApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(VisiteurApiService.class);
        Call<ArrayList<Praticien>> call = apiService.getPraticiensPortefeuille(token, userId);
        call.enqueue(new Callback<ArrayList<Praticien>>() {
            @Override
            public void onResponse(Call<ArrayList<Praticien>> call, Response<ArrayList<Praticien>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Au lieu de remplacer la référence, videz et ajoutez
                    praticienList.clear();
                    praticienList.addAll(response.body());
                    // Informez l'adaptateur que les données ont changé
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Praticien>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}