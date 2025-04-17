package com.example.gsb_visite.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsb_visite.API.RetrofitClientInstance;
import com.example.gsb_visite.API.VisiteurApiService;
import com.example.gsb_visite.Model.Praticien;
import com.example.gsb_visite.databinding.ActivityPraticienInformationsBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PraticienInformationsActivity extends AppCompatActivity {

    private ActivityPraticienInformationsBinding binding;
    private String token;
    private String praticien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPraticienInformationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Récupérer les données de l'intent
        Intent intent = getIntent();
        Praticien praticien = (Praticien) intent.getSerializableExtra("praticien");
        token = "Bearer " + intent.getStringExtra("token");

        // Configurer le bouton de retour
        binding.btnBack.setOnClickListener(v -> finish());

        displayPraticienInfo(praticien);
    }


    private void displayPraticienInfo(Praticien praticien) {
        binding.tvPraticienName.setText(praticien.getNom() + " " + praticien.getPrenom());
        binding.tvSpecialite.setText("Information non disponible");
        binding.tvAdresse.setText(praticien.getRue());
        binding.tvCodePostal.setText(praticien.getCodePostal());
        binding.tvVille.setText(praticien.getVille());
        binding.tvTelephone.setText(praticien.getTel());
        binding.tvEmail.setText(praticien.getEmail());

        // Configurer le bouton pour planifier une visite
        binding.btnCreerVisite.setOnClickListener(v -> {
            // Ajouter ici la logique pour planifier une visite
            Toast.makeText(PraticienInformationsActivity.this,
                    "Fonctionnalité de planification à implémenter", Toast.LENGTH_SHORT).show();
        });
    }
}