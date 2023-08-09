package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.MetaKeyKeyListener;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    MediaPlayer ses1;
    Button b1,b8;
    TextView t1;
    ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ses1= MediaPlayer.create(MainActivity.this,R.raw.s1);
         b1= findViewById(R.id.b1);
         t1= findViewById(R.id.t1);
         im1= findViewById(R.id.im1);
         b8=findViewById(R.id.b8);
         ses1.start();

         // oyuna başla butonuna basıldığında
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent sayfa2 = new Intent(MainActivity.this,Activity2.class);
                 ses1.pause();
                 startActivity(sayfa2);
             }
         });
         //Oyundan çık butonuna basıldığında uygulamayı kapat
         b8.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent setIntent = new Intent(Intent.ACTION_MAIN);
                 setIntent.addCategory(Intent.CATEGORY_HOME);
                 setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 ses1.pause();
                 startActivity(setIntent);
             }
         });
    }
}