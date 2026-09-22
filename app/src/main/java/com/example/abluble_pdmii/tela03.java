package com.example.abluble_pdmii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class tela03 extends AppCompatActivity implements View.OnClickListener, Runnable{
    private ViewPager2 viewPager;
    private ArrayList<slide> lista, texto;
    private Button sair;
    private TextView textinho;

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
        textinho = findViewById(R.id.textView5);

        lista = new ArrayList<slide>();
        lista.add(new slide("ちいかわ", R.drawable.chiikawa_p,"Chiikawa (ちいかわ;' Algo meio pequeno e fofo ')\n" +
                "    Dublado por: Haruka Aoki]\n" +
                "    Chiikawa é o protagonista titular da franquia.  Chiikawa é de tamanho pequeno, tem orelhas arredondadas e uma cauda em forma de lágrima, assemelhando-se a um rato ou a um hamster. No início, Chiikawa foi nomeado como Nitori. Covarde, tímido, e tendo uma tendência a chorar, eles vivem em uma casa ganha na loteria Muchauma Yogurt. Ao contrário de alguns outros personagens, Chiikawa não pode, na maior parte, falar de uma forma que é inteligível para o público – principalmente dizendo coisas como \"yada\" e \"iya\" - ambos os quais são maneiras infantis de dizer \"não\" em japonês. Eles se expressam principalmente através de sons e expressões faciais, mas é compreensível para o resto do elenco. "));
        lista.add(new slide("ハチワレ", R.drawable.hachi_p,"Hachiware (ハチワレ;' Oito-split ou Broken-helmet ')\n" +
                "    Dublado por: Makoto Tanaka  [ja][14]\n"+
                "    Hachiware, originalmente nomeado Ikeya,[[9] é amigo de Chiikawa e Usagi e vive em uma caverna. O nome e o design da Hachiware são baseados nos de um gato bicolor, embora não sejam um.[ Hachiware é retratado como conversador, curioso e otimista, além de ser de bom coração e disposto a ajudar seus amigos, especialmente Chiikawa. Hachiware também é um ávido fotógrafo, e eles gostam do Charumera marca de ramen instantâneo."));
        lista.add(new slide("うさぎ", R.drawable.usagi_p,"Usagi (うさぎ;' Coelho ')\n" +
                "    Dublado por: Ari Ozawa[14]]\n" +
                "    Usagi, originalmente chamado Donki,[[9] é um amigo de Chiikawa e Hachiware. Retratados como de espírito elevado, eles ocasionalmente agem como um desordeiro, mas apoiam seus amigos quando estão em apuros. Semelhante a Chiikawa, Usagi é ininteligível para o público, fazendo barulhos como \"una\" e \"yaha\", mas pode ser entendido para os outros personagens. O nome e o design de Usagi são baseados nos de um coelho, embora \"possam ou não\" ser um. Usagi é conhecido principalmente por ser excêntrico e um foodie."));
        lista.add(new slide("モモンガ", R.drawable.momonga_p,"Momonga (モモンガ;' Esquilo voador ')\n" +
                "    Dublado por: Iguchi Yuka[18]]\n" +
                "    Momonga é um esquilo voador impertinente e brincalhão. Eles são sempre focados em agir bonito, implorar por atenção, e muitas vezes lança birras, contrastando com os outros. Mesmo em situações perigosas, eles pediam comida e descanso. Em busca de seu objetivo, Momonga muitas vezes \"age bonito\". Embora não tenham conhecimento em pistas sociais, eles fazem um esforço ativo para imitar as ações fofas de outros personagens, notavelmente Chikawa. Em particular, eles muitas vezes imitam o bocejo e o choro de Chiikawa. Embora principalmente descritos como fazendo coisas por conta própria, em capítulos posteriores eles começam a sair com Furuhonya, embora principalmente para benefício pessoal. Está muito implícito que Dekatsuyo trocou de corpo com Momonga com a ajuda de uma bruxa."));
        lista.add(new slide("ラッコ", R.drawable.rakko_p,"Rakko (ラッコ;' Lontra do mar ')\n" +
                "    Dublado por: Yuma Uchida[18]]\n" +
                "    Rakko é uma lontra marinha que se destaca na batalha, e está no topo do ranking de subjugação. Parece muito sério, mas tem um ponto fraco para sobremesas. Rakko também tem um carro e é capaz de dirigir."));
        lista.add(new slide("くりまんじゅう", R.drawable.kurimanju_p,"Kuri-Manjū (くりまんじゅう;' Coque de castanha ')\n" +
                "    Dublado por: Takayuki Asai  [ja]][18\n" +
                "    O design de caráter de Kuri-manjū é baseado em um texugo de mel e Kuri Manju (ja:栗饅頭), um pão de confeitaria japonês feito com recheios de castanha. É sempre visto bebendo álcool e comendo vários alimentos, geralmente emitindo um hálito alto e exagerado depois de tomar um gole de sua bebida.  [   Aliás, na região onde vivem, beber álcool só é permitido se um carrega uma licença que pode ser obtida apenas passando por um exame difícil."));
        slideAdapter adapter = new slideAdapter(lista, textinho);
        viewPager.setAdapter(adapter);

        sair = findViewById(R.id.button);
        sair.setOnClickListener(this);





    }

    @Override
    public void run() {

    }
    @Override
    public void onClick(View v) {
        if(v == sair)
        {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}