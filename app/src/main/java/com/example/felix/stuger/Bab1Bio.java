package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Bio extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Kelompok organisme yang terdiri dari berbagai spesies yang tinggal bersama dalam lingkungan tertentu disebut ..",
            "2.Luna Maya mengamati sayatan daun Rhoeo discolor dengan menggunakan mikroskop. Untuk memahami bentuk-bentuk sel yang teramati pada sediaan tersebut ia perlu mempelajari cabang biologi…",
            "3.Berikut ini yang merupakan aplikasi cabang biologi di bidang mikrobiologi adalah …",
            "4.Sebuah penelitian berjudul “Pengaruh lama perendaman terhadap perkecambahan biji jagung”. Variabel bebas pada penelitian tersebut adalah …",
            "5.Dugaan sementara terhadap suatu masalah sebelum dibuktikan kebenarannya adalah …",
            "6.Berikut ini adalah manfaat biologi di bidang pertanian, kecuali …",
            "7.HIV sebagai penyebab AIDS akan mengakibatkan orang yang terinfeksi mengalami ....",
            "8.Mencegah wabah penyakit .....   Vaksin yang dapat diberikan secara oral (melalui     mulut) adalah vaksin untuk     ",
            "9.Medium yang paling cocok untuk menumbuhkan virus adalah ....",
            "10.Salah satu sifat dari virus adalah ....",
    };
    String[] pilihan_jawaban = new String []{
            "populasi","komunitas","ekosistem","bioma",
            "mikrobiologi","morfologi","histologi","fisiologi",
            "pembuatan yogurt","inseminasi buatan","penyisipan gen","super ovulasi",
            "cahaya","biji jagung","air","lama perendaman",
            "observasi","analisis","penafsiran data","hipotesis",
            "kultur jaringan","teknik pemupukan yang tepat","penemuan vaksin","penyilangan tanaman",
            "peningkatan leukosit","kerusakan hati dan limpa","lemahnya sistem kekebalan","penurunan kadar eritrosit",
            "polio","demam berdarah","rabies","cacar",
            "agar-agar","telur ayam busuk","embrio ayam yang masih hidup","embrio tikus putih yang sudah mati",
            "dapat hidup pada sel hidup dan tidak hidup","memiliki inti sel dan organel sel","selnya berbentuk coccus","dapat dilihat menggunakan mikroskop cahaya",
    };
    String[] jawaban_benar = new String[]{
            "komunitas",
            "fisiologi",
            "pembuatan yogurt",
            "lama perendaman",
            "hipotesis",
            "penemuan vaksin",
            "lemahnya sistem kekebalan",
            "polio",
            "embrio ayam yang masih hidup",
            "memiliki inti sel dan organel sel",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_bio);
        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }
    public void next(View view){
        if(PilihanA.isChecked()||PilihanB.isChecked()||PilihanC.isChecked()||PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 10;
                Intent selesai = new Intent(getApplicationContext(), HasilKuisBio1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
