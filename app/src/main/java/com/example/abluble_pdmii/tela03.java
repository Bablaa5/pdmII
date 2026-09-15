package com.example.abluble_pdmii;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class tela03 extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ArrayList<slide> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewPager = findViewById(R.id.viewpager);
        lista = new ArrayList<slide>();
        lista.add(new slide("ちいかわ", R.drawable.chiikawa_p,"criatura pequena e fofa"));
        lista.add(new slide("ハチワレ", R.drawable.hachi_p,"gato bicolor"));
        lista.add(new slide("うさぎ", R.drawable.usagi_p,"coelho estranho"));
        lista.add(new slide("モモンガ", R.drawable.momonga_p,"esquilo desgraçado"));
        lista.add(new slide("ラッコ", R.drawable.rakko_p,"muito maneiro"));
        lista.add(new slide("くりまんじゅう", R.drawable.kurimanju_p,"alcoólatra"));
        slideAdapter adapter = new slideAdapter(lista);
        viewPager.setAdapter(adapter);


    }
}