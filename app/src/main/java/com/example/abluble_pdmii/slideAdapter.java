package com.example.abluble_pdmii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class slideAdapter extends RecyclerView.Adapter<slideHolder> {
    private ArrayList<slide> lista;
    private TextView textinho;
    public slideAdapter(ArrayList<slide> lista){

        this.lista = lista;
    }
    public slideAdapter(ArrayList<slide> lista, TextView textinho){

        this.lista = lista;
        this.textinho = textinho;
    }

    @NonNull
    @Override
    public slideHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);

        return new slideHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull slideHolder holder, int position) {
        holder.titulo.setText(lista.get(position).getNome());
        holder.imagem.setImageResource(lista.get(position).getImagem());
        textinho.setText(lista.get(position).getTexto());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
