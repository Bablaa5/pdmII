package com.example.abluble_pdmii;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class tela04 extends AppCompatActivity {

    private Button b_verifica, b_continua;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela04);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navigationView = findViewById(R.id.nv4);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.idhome) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(tela04.this, TelaHome.class));
                    return false;
                }
                if (menuItem.getItemId() == R.id.idtela02) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(tela04.this, tela02.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idtela03) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(tela04.this, tela03.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idtela04) {
                    drawerLayout.closeDrawers();
                    return true;
                }
                if (menuItem.getItemId() == R.id.idsobre) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(tela04.this, SobreActivity.class));
                    return true;
                }
                return false;
            }


        });
    }}