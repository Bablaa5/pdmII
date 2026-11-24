package com.example.abluble_pdmii;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class tela04 extends AppCompatActivity {

    private Button b_verifica, b_continua;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private RadioButton rb1, rb2, rb3, rb4;
    private ArrayList <perguntas> Lista_pergunta;
    private TextView pergunta;

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

        rb1 = findViewById(R.id.radioButton4);
        rb2 = findViewById(R.id.radioButton3);
        rb3 = findViewById(R.id.radioButton2);
        rb4 = findViewById(R.id.radioButton);
        pergunta = findViewById(R.id.textView_pergunta);

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
    }
    public void carregar_perguntas(){
        Lista_pergunta = new ArrayList<perguntas>();
        Lista_pergunta.add(new perguntas("usagi é o que","coelho","furão","baleia","rato","coelho"));
        Lista_pergunta.add(new perguntas("chiikawa é o que","gato","panda","urso","rato","urso"));
        Lista_pergunta.add(new perguntas("o que chiikawa significa","urso","fofo","pequeno e fofo","estranho","pequeno e fofo"));
        Lista_pergunta.add(new perguntas("hachiware é o que","momonga, kurimanju e chiikawa","chiikawa e kurimanju","momonga kurimanju, usagui","rato","gato"));
        Lista_pergunta.add(new perguntas("hachiware é","mentiroso","traidor","gentleman","rato","gentleman"));
        Lista_pergunta.add(new perguntas("qual o trio principal","coelho","furão","usagui, hachiware e momonga","chiikawa, usagui e hachiware","chiikawa, usagui e hachiware"));
        Lista_pergunta.add(new perguntas("momonga é ____","mentiroso","um desgraçado","vibes","brother","um desgraçado"));
        Lista_pergunta.add(new perguntas("nome do alcóolatra","kurimanju","hachiware","pão","momonga","kurimanju"));
        Lista_pergunta.add(new perguntas("kurimanju é inspirado em que","toupeira","furão","pão","kanguru","pão"));
        Lista_pergunta.add(new perguntas("chiikawa trabalha","sim, trabalha em loja","não, não existe dinheiro","não, é uma criança","sim, pega grama","sim, pega grama"));
        Lista_pergunta.add(new perguntas("no universo chiikawa não existem:","canibais","humanos","monstros","bruxas","humanos"));
        Lista_pergunta.add(new perguntas("hachiware é","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAAA","um anjo","um anjo"));
        Lista_pergunta.add(new perguntas("una una?","usagui","hachiware","chiikawa","momonga","usagui"));
        Lista_pergunta.add(new perguntas("u uwawa u wa","itao tao wa","wawa urarachi","urarachi itao tao","wawa uwa","urarachi itao tao"));
        Lista_pergunta.add(new perguntas("usagui já ficou de que cor","azul","vermelho","azul escuro","verde","vermelho"));
        Lista_pergunta.add(new perguntas("qual o melhor?","usagui","hachiware","chiikawa","momonga","hachiware"));
        Lista_pergunta.add(new perguntas("qual o pior?","usagui","hachiware","chiikawa","momonga","momonga"));
        Lista_pergunta.add(new perguntas("qual mais mimadinho insuportável?","usagui","hachiware","chiikawa","momonga","momonga"));
        Lista_pergunta.add(new perguntas("quem que ta estudando igual um vestibulando e ta muito triste?","usagui","hachiware","chiikawa","momonga","chiikawa"));
        Lista_pergunta.add(new perguntas("qual não se importa com nada?","usagui","hachiware","chiikawa","momonga","usagui"));

    }
}