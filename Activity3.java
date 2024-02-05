package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    MediaPlayer ses3,ses4;
    Intent sayfa3=getIntent();
    Button b4,b5;
    TextView t7,t9,t10;
    ImageView im3;
    int sonuc;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        t7=findViewById(R.id.t7);
        t9=findViewById(R.id.t9);
        t10=findViewById(R.id.t10);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        im3=findViewById(R.id.im3);
        Bundle s=getIntent().getExtras();
        Bundle b=getIntent().getExtras();
        Bundle p=getIntent().getExtras();
        String sonuc =String.valueOf(b.getInt("sonuc"));
        String sehir = s.getString("sehir");
        String puan= String.valueOf(p.getInt("puan"));
        ses3=MediaPlayer.create(Activity3.this,R.raw.s3);
        ses4=MediaPlayer.create(Activity3.this,R.raw.s4);

        // adam asımında olacaklar
        if(sonuc.equals("0")) {
            t7.setText("Malesef rehineyi kurtaramadın .. :/");
            im3.setImageResource(R.drawable.e);
            ses3.start();
        }
        // doğru tahminde olacaklar
        if(sonuc.equals("1")) {
            t7.setText("Yaşasın ! Rehine artık özgür :)");
            im3.setImageResource(R.drawable.g);
            ses4.start();
        }
        t9.setText("Doğru cevap: "+sehir);
        t10.setText("Puanınız: "+puan);

        // Yeniden oyna butonuyla gerçekleşecekler
        b4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent anamenu= new Intent(Activity3.this,Activity2.class);
              ses3.pause();
              ses4.pause();
            startActivity(anamenu);
          }
        });
        
        // ana menüye dön butonu ile gerçekleşecekler
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sayfa2= new Intent(Activity3.this,MainActivity.class);
                ses3.pause();
                ses4.pause();
                startActivity(sayfa2);
            }
        });
    }
}
