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

    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekbar;
    private Handler handler;
    private Button b;
    private int musica,indiceLista;
    private ArrayList<Playlist> lista;
    private CardView card1, card2, card3, card4,card5;
    private TextView textoMusicaSeleciona, textoMusicaTocando;
    private ImageView imgPreview, imgNext;

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
        //atribui a toolbar o poder de actionbar
        setSupportActionBar(toolbar);
        //habilita o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(this);
        handler =  new Handler();


        musica = R.raw.josefina;

        lista = new ArrayList<Playlist>();
        lista.add(new Playlist("Josefina", R.raw.josefina));
        lista.add(new Playlist("Higer Water", R.raw.higher_water));
        lista.add(new Playlist("Hard Red Heart", R.raw.hard_red_heart));
        lista.add(new Playlist("Ancient History", R.raw.ancient_history));
        lista.add(new Playlist("No one here gets in alive", R.raw.no_one_here_gets_in_alive));

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
        textoMusicaSeleciona = findViewById(R.id.textView2);
        textoMusicaTocando = findViewById(R.id.textView3);

        imgPreview = findViewById(R.id.imageView);
        imgPreview.setOnClickListener(this);
        imgNext = findViewById(R.id.imageView3);
        imgNext.setOnClickListener(this);



    }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

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

    }

    @Override
    public void run() {
        if(mediaPlayer!= null){
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this,1000);
        }

    }

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
    public void play(){
        if(mediaPlayer== null){
            mediaPlayer = MediaPlayer.create(this, lista.get(indiceLista).getMusica());
            textoMusicaTocando.setText("Música tocando: "+lista.get(indiceLista).getNome());
            mediaPlayer.setOnCompletionListener(this);
            seekbar.setMax(mediaPlayer.getDuration());
            handler.post(this);
            mediaPlayer.start();
        }else if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            handler.post(this);

        }
    }

    public void stop(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}


