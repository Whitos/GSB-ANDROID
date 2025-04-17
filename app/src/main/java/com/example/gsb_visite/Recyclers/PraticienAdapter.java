package com.example.gsb_visite.Recyclers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsb_visite.Activities.PraticienInformationsActivity;
import com.example.gsb_visite.Model.Praticien;
import com.example.gsb_visite.R;

import java.util.List;

public class PraticienAdapter extends RecyclerView.Adapter<PraticienAdapter.ViewHolder> {

    private List<Praticien> praticiens;
    private String token;

    public PraticienAdapter(List<Praticien> praticiens) {
        this.praticiens = praticiens;
        this.token = token;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_praticiens, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Praticien praticien = praticiens.get(position);
        holder.tvPraticien.setText(praticien.getPrenom() + " " + praticien.getNom());
    }

    @Override
    public int getItemCount() {
        return praticiens != null ? praticiens.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPraticien;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPraticien = itemView.findViewById(R.id.tvPraticien);
            cardView = itemView.findViewById(R.id.card_praticien);
        }
    }
}