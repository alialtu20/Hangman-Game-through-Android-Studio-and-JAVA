package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Locale;

public class Activity2 extends AppCompatActivity  {
    MediaPlayer ses2;
    Intent sayfa3;
    TextView t2,t3,t4,t5,t6,t8,t11;
    ImageView img2;
    EditText g1;
    Button b2,b3;
    int rand1,rand2;
    int k=0;
    int t=1;
    int m=1;
    int n,hak,puan=0,dene=0;
    int []tekrar=new int[3];
    String sehird="";
    String sehir="";
    String [] sehirs = {"Adana","Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir","Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum","Denizli","Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
            "Gaziantep", "Giresun","Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
            "Kars", "Kastamonu", "Kayseri","Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya",
            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak",
            "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak",
            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        t2= findViewById(R.id.t2);
        t3= findViewById(R.id.t3);
        t4= findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t8=findViewById(R.id.t8);
        t6=findViewById(R.id.t6);
        t11=findViewById(R.id.t11);
        g1= findViewById(R.id.gir1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        img2=findViewById(R.id.img2);

        //  kronometrenin geri sayması
        CountDownTimer timer= new CountDownTimer(31000,1000) {

            @Override
            public void onTick(long saniye) {
                t6.setText("Time: "+String.valueOf(saniye/1000));
            }

            @Override
            // kronometrenin sayımı bittikten sonra beklenenler
            public void onFinish() {
               if(m==1) {
                   sayfa3 = new Intent(Activity2.this, Activity3.class);
                   sayfa3.putExtra("sonuc", 0);
                   sayfa3.putExtra("sehir",sehir);
                   sayfa3.putExtra("puan",puan);
                   ses2.pause();
                   startActivity(sayfa3);
               }
            }
        }.start();
        
        // 81 il için rastgele indis ataması
        rand1= (int) (Math.random()*81);

        // ekrandaki alt çizgi+boşlukların şehir boyutuna göre dizilmesi
        for (int i = 0; i < sehirs[rand1].length(); i++) {
            sehird = sehird + "_ ";
            t2.setText(sehird);
        }
        sehir=sehirs[rand1];

        // Şehrin kelime uzunluğuna göre harf alma hakkı tanınması
        if(sehir.length()<20) {
            hak=3;
        }
        if(sehir.length()<8) {
            hak=2;
        }
        if(sehir.length()<6) {
            hak=1;
        }
        
        t5.setText("Kalan hakkınız : "+String.valueOf(hak));
        ses2=MediaPlayer.create(Activity2.this,R.raw.s2);
        ses2.start();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // verilen hak kadar harf alma mekanizması
                if (k < hak) {
                    // şehirdeki aynı karakter indisinin birbirini tekrarlamaması için do while algoritması
                    do {
                        rand2 = (int) (Math.random() * sehirs[rand1].length());

                        // seçilen random indis tekrar dizisindeki indis elemanlarıyla karşılaştırılır .
                        for (int i = 0; i < k; i++) {
                            if (tekrar[i] == rand2) {
                                n = 0;
                                break;
                            }
                            n = 1;
                        }
                        // tekrarlama olmadığında tekrar dizisine tekrarlanmayan indis atılır
                        if (n == 1 | k == 0) {

                            tekrar[k] = rand2;

                            n = 1;

                            k++;
                            t5.setText("Kalan hakkınız : "+String.valueOf(hak-k));
                        }

                    } while (n == 0);
                    sehird = "";
                    
                    // sehirdeki rastgele seçilen karakterin yanması
                    for (int i = 0; i < sehirs[rand1].length(); i++) {
                        
                        // şehirdeki her indis tekrar dizisindeki elemanlarla karşılaştırılır
                        for (int j = 0; j < k; j++) {
                            // elemanlar eşleştiğinde ekrana o karakter basılır
                            if (tekrar[j] == i) {
                                sehird = sehird + String.valueOf(sehir.charAt(i)) + " ";
                                t = 1;
                                break;
                            }
                            t = 0;
                        }
                        // elemanlar indisle eşleşmiyorsa alt çizgi konur
                        if (t == 0) {
                            sehird = sehird + "_ ";
                        }
                    }
                    t2.setText(sehird);
                    
                    // dene mekanizmaları ile adam asmaca figürleri hareket eder .
                    if(dene==0){
                    img2.setImageResource(R.drawable.b);
                    }
                    if(dene==1){
                        img2.setImageResource(R.drawable.c);
                    }
                    if(dene==2){
                        img2.setImageResource(R.drawable.d);
                    }
                    dene++;
                    puan=puan-100;
                }
                // harf alma hakkı bittiğinde tost mesajı belirmesi
                else {
                    Toast.makeText(getApplicationContext(), hak+" Adet hakkınız tükenmiştir", Toast.LENGTH_SHORT).show();
                }
                t8.setText("Puan: "+puan);
            }
         });
        
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // tahmin şehrin eşleşmesi durumu
              if(sehir.toLowerCase().equals(g1.getText().toString().toLowerCase())) {
                  dene=5;
                  sayfa3 = new Intent(Activity2.this,Activity3.class);
                  sayfa3.putExtra("sonuc",1);
                  sayfa3.putExtra("sehir",sehir);
                  puan=puan+600;
                  sayfa3.putExtra("puan",puan);
                  m=0;
                  ses2.pause();
                  startActivity(sayfa3);
              }
                puan=puan-200;
              // dene mekanizmalarıyla adam asmaca figürlerinin hareket etmesi
                if(dene==0 ){
                    img2.setImageResource(R.drawable.b);
                }
                if(dene==1){
                    img2.setImageResource(R.drawable.c);
                }
                if(dene==2){
                    img2.setImageResource(R.drawable.d);
                }
                // adam asımında olacaklar
                if(dene==3){
                    sayfa3 = new Intent(Activity2.this,Activity3.class);
                    sayfa3.putExtra("sonuc",0);
                    sayfa3.putExtra("sehir",sehir);
                    sayfa3.putExtra("puan",puan);
                    m=0;
                    ses2.pause();
                    startActivity(sayfa3);
                }
                t8.setText("Puan: "+puan);
                dene++;
            }
        });
    }
}
