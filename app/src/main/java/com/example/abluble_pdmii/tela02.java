package com.example.abluble_pdmii;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, Runnable, View.OnClickListener {
//principio de po (varias interfaces,
// usando o metodo escutador de evento, esperam uma ação de toque)
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekbar;
    private Handler handler;
    private Button b;
    private int musica,indiceLista;
    private ArrayList<Playlist> lista;
    private CardView card1, card2, card3, card4,card5;
    private TextView textoMusicaSeleciona, textoMusicaTocando, placarTempoAtual, placarTempoRestante;
    private ImageView imgPreview, imgNext;

    //variavéis
    //media palyer --> reproduzir um objeto do tipo musica

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //habilita o botão de voltar
        //atribui a toolbar o poder de actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //(da p adc btn, esse é o de voltar)
        seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(this);

        handler =  new Handler();

        musica = R.raw.josefina; //(set a musica pelo raw)
        lista = new ArrayList<Playlist>();
        lista.add(new Playlist("Josefina", R.raw.josefina));
        lista.add(new Playlist("Higer Water", R.raw.higher_water));
        lista.add(new Playlist("Hard Red Heart", R.raw.hard_red_heart));
        lista.add(new Playlist("Ancient History", R.raw.ancient_history));
        lista.add(new Playlist("No one here gets in alive", R.raw.no_one_here_gets_in_alive));
        //faz uma lista e adc as musicas

        card1 =  findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 =  findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 =  findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 =  findViewById(R.id.card4);
        card4.setOnClickListener(this);
        card5 =  findViewById(R.id.card5);
        card5.setOnClickListener(this);
        //instanciando cards
        textoMusicaSeleciona = findViewById(R.id.textView2);
        textoMusicaTocando = findViewById(R.id.textView3);

        placarTempoAtual = findViewById(R.id.textView6);
        placarTempoRestante = findViewById((R.id.textView7));

        imgPreview = findViewById(R.id.imageView);
        imgPreview.setOnClickListener(this);
        imgNext = findViewById(R.id.imageView3);
        imgNext.setOnClickListener(this);

        // mapeamento blabla


    }
    public String formatarTempo(int tempo){
        int segundos = tempo/1000;
        int minutos = segundos/60;
        segundos = segundos%60;
        String tempoFormatado = String.format("%02d:02d", minutos, segundos);
        return tempoFormatado;
    }
    //metodo que recebe como paramentros
    // de entrada milisegundos e converte em segundo e minutos


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        if (id == R.id.id001){
            play();
        }
        if(id == R.id.id003){
            stop();
        }
        if(id == R.id.id002){
            if(mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
        return false;
    }
    // trata das ações do menu overflow (funções da toolbar)
    // pause, play, etc


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    // menu que infla os incones na action bar

    @Override
    public void onCompletion(MediaPlayer mp) {
        handler.removeCallbacks(this);
        mp.release();
        mediaPlayer = null;
        seekbar.setProgress(0);
        indiceLista++;
        if(indiceLista >= lista.size()){
            indiceLista = 0;
        }
        textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
    }
    //chamado quando a musica termina, tocou inteira.
    // --> quando a musica acaba ele atualiza a seekbar e
    // aumenta o indice para seguir a lista (conferindo se esta dentro dos limites)

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if(mediaPlayer != null){
            mediaPlayer.seekTo(seekBar.getProgress());
        }
    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(mediaPlayer!=null){
            mediaPlayer.seekTo(seekBar.getProgress());
        }
    }
    //atualiza o seekbar de acordo com a media player :)

    @Override
    public void run() {
        if(mediaPlayer!= null){
            int tempoAtual = mediaPlayer.getCurrentPosition();
            int duracao = mediaPlayer.getDuration();
            int tempoRestante = duracao - tempoAtual;
            placarTempoAtual.setText(formatarTempo(tempoAtual));
            placarTempoRestante.setText("-"+formatarTempo(tempoRestante));

            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this,1000);
        }
    }
    //atualiza o placar (inicio e restante da música) adc na seekbar

    @Override
    public void onClick(View v) {
        if(v == card1){
            indiceLista = 0;
            textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if(v == card2){
            indiceLista = 1;
            textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if(v == card3){
            indiceLista = 2;
            textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if(v == card4){
            indiceLista = 3;
            textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if(v == card5){
            indiceLista = 4;
            textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }

        if(v == imgPreview){
            indiceLista--;
            if(indiceLista < 0){
                indiceLista = lista.size()-1;
            }
            textoMusicaSeleciona.setText("Música selencionada: "+lista.get(indiceLista).getNome());
            stop();
            play();

        }
        if(v == imgNext){
            indiceLista++;
            if(indiceLista >= lista.size()){
                indiceLista = 0;
            }
            textoMusicaSeleciona.setText("Música selencionada: "+lista.get(indiceLista).getNome());
            stop();
            play();

        }

    }
    //if para cada card o relacionando com uma música da lista
    public void play(){
        if(mediaPlayer== null){
            mediaPlayer = MediaPlayer.create(this, lista.get(indiceLista).getMusica());
            //textoMusicaTocando.setText("Música tocando: "+lista.get(indiceLista).getNome());
            toolbar.setTitle(lista.get(indiceLista).getNome());
            int x = indiceLista;
            x++;
            toolbar.setSubtitle((Integer.toString(x)+" de "+Integer.toString(lista.size())));


            mediaPlayer.setOnCompletionListener(this);
            seekbar.setMax(mediaPlayer.getDuration());
            handler.post(this);
            mediaPlayer.start();
        }else if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            handler.post(this);

        }
    }
    //metodo para criar a musica e set o título

    public void stop(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    //metodo verifica se esta nulo, ele traz o stop e release

}


