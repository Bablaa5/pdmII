package com.example.abluble_pdmii;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class slideHolder extends RecyclerView.ViewHolder {
    public TextView titulo, texto;
    public ImageView imagem;


    public slideHolder(@NonNull View itemView) {
        super(itemView);
        titulo = itemView.findViewById(R.id.textView);
        imagem = itemView.findViewById(R.id.imageView4);
    }
}
