package com.example.gsb_visite.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsb_visite.API.RetrofitClientInstance;
import com.example.gsb_visite.API.VisiteurApiService;
import com.example.gsb_visite.Model.Visiteur;
import com.example.gsb_visite.databinding.ActivityLoginBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuration du bouton de connexion
        binding.btnConnexion.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            if (validateInputs(email, password)) {
                loginUser(email, password);
            }
        });
    }

    private boolean validateInputs(String email, String password) {
        boolean isValid = true;

        if (email.isEmpty()) {
            binding.etEmail.setError("Email requis");
            isValid = false;
        }

        if (password.isEmpty()) {
            binding.etPassword.setError("Mot de passe requis");
            isValid = false;
        }

        return isValid;
    }

    private void loginUser(String email, String password) {
        // Préparer les données de connexion
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        // Appel à l'API
        VisiteurApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(VisiteurApiService.class);
        Call<Visiteur> call = apiService.login(credentials);
        call.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Visiteur visiteur = response.body();

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("userId", visiteur.getUserId());
                    intent.putExtra("token", visiteur.getToken());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Échec de connexion", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Visiteur> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}