package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab3Math extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Sebuah taman berbentuk persegi. Di sekeliling taman itu ditanami pohon cemara dengan jarak antar pohon 8 m. Panjang sisi taman itu adalah 78 m. Berapakah banyak pohon cemara yang dibutuhkan?",
            "2.Siswa SMP Andalan sebanyak 140 anak membentuk suatu barisan. Barisan pertama terdiri dari 5 anak. Dan setiap barisan berikutnya selalu bertambah 2 anak dari barisan sebelumnya. Banyak barisan yang dapat dibentuk oleh seluruh siswa tersebut adalah ... ",
            "3.Jika untuk mengecat dinding yang berukuran 6 m2 dibutuhkan 4 kaleng cat, maka untuk mengecat dinding yang berukuran 15 m2  dibutuhkan kaleng cat sebanyak ...",
            "4.Diketahui segitiga sama sisi dengan panjang sisinya adalah 16 cm. Luas segitiga tersebut adalah ...",
            "5.Sebuah bangun ruang berbentuk tabung dengan tutup setengah bola mempunyai diameter 14 cm. Jika tinggi tabung tersebut adalah 20 cm, maka luas permukaan bangun ruang tersebut adalah ...",
            "6.Jarak Sebenarnya antara 2 kota adalah 80km , sedangkan jarak pada peta 5cm. Skala peta tersebut adalah...",
            "7.Seorang siswa berhasil menjawab dengan benar 28 soal, salah 8 soal, serta tidak menjawab 4 soal. Bila satu soal dijawab benar nilainya 4, salah nilainya -3, serta tidak menjawab    nilainya  -1. maka nilai yang diperoleh siswa tersebut adalah ……",
            "8.Suatu jenis pupuk terdiri dari 50% ammonium, 35% super fosfat, dan sisanya besi sulfat. Jika berat pupuk tersebut 15 kg, maka berat besi sulfat adalah …….",
            "9.Panjang sebuah pulau sesungguhnya adalah 1.458 km. pulau itu tergambar dengan panjang 54 cm pada sebuah peta. Skala peta itu adalah ……",
            "10.Jumlah dua bilangan pecahan saling berkebalikan adalah  34/15 . Jika salah satu penyebut bilangan itu adalah 5. salah satu bilangan tersebut adalah ……."
    };
    String[] pilihan_jawaban = new String []{
            "30 buah","35 buah","39 buah","40 buah",
            "6","10","11","12",
            "10","9","8","7",
            "64","12","45","25",
            "1432 cm2","1342 cm2","1324 cm2","1243 cm2",
            "1:400","1:4000","1:160.000","1:1.600.000",
            "96","88","84","91",
            "22,5 gr","2.25 gr","22.5 kg","2.25 kg",
            "1 : 270.000","1 : 300.000","1 : 2.700.000","1 : 787.320",
            "2/5","3/5","5/4","5/6",
    };
    String[] jawaban_benar = new String[]{
            "39 buah",
            "10",
            "10",
            "25",
            "1342 cm2",
            "1:1.600.000",
            "84",
            "2.25 kg",
            "1 : 2.700.000",
            "3/5"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_math);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisMath3.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
