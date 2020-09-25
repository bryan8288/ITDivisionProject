package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Fis extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Pipa organa terbuka A dan pipa organa tertutup-sebelah B mempunyai panjang yang sama. Perbandingan frekuensi nada atas pertama antara pipa organa A dan pipa organa B adalah.... ",
            "2.Sebuah keping logam yang mempunyai energi ambang 2 ev disinari dengan cahaya monokromatis dengan panjang gelombang 6000 Å hingga elektron meninggalkan permukaan logam. Jika h = 6,6 × 10−34 Js dan kecepatan cahaya 3 × 108 m/detik, maka energi kinetik elektron yang lepas....",
            "3.Permukaan katode disinari cahaya sampai pada frekuensi tertentu, ternyata tidak terjadi foto elektron. Agar permukaan katode memancarkan foto elektron, usaha yang dapat dilaksanakan adalah … ",
            "4.Cahaya dengan panjang gelombang 500 nm meradiasi permukaan logam yang fungsi kerjanya 1,86 × 10–19 joule. Energi kinetik maksimum foto elektron adalah ..",
            "5.Frekuensi ambang suatu logam sebesar 8 × 1014 Hz, dan logam tersebut disinari dengan cahaya yang mempunyai frekuensi 1015 Hz. Jika tetapan Planck = 6,6 × 10–34 J s, maka energi kinetik foto elektron yang terlepas dari permukaan logam tersebut adalah … ",
            "6.Frekuensi ambang natrium adalah 4,4 x 1014 Hz. Besar potensial penghenti dalam volt bagi natrium saat disinari dengan cahaya yang frekuensinya 6,0 x 1014 Hz adalah... ",
            "7.Sebuah partikel alpha (m = 6,4×10–27 kg, q = 3,2×10–19 C) bergerak tegak lurus terhadap medan magnet B yang arahnya masuk bidang gambar. Jika B = 0,2 T dan kecepatan partikel 3×105 m/s, maka jari-jari lintasannya adalah... ",
            "8.Suatu muatan positif dari 0,2 C bergerak dengan kecepatan 2 m/s dalam medan magnetik yang besarnya 5 Wb/m2. Arah kecepatan muatan itu sejajar dengan arah medan magnetik.Gaya yang dialami muatan tersebut adalah... ",
            "9.Partikel bermuatan q bergerak dengan kelajuan tetap memasuki medan magnetik dan medan listrik secara tegak lurus (medan listrik tegak lurus medan magnetik). Apabila besar induksi magnetik 0,2 T dan kuat medan listrik 6 x 104 V/m, maka kelajuan gerak partikel adalah.... ",
            "10.Sebuah solenoida yang mempunyai 500 lilitan, dialiri arus searah sehingga timbul fluks magnet sebesar 2 . 10–3 weber. Jika induktansi solenoida 0,4 henry maka arus yang mengalir besarnya.."
    };
    String[] pilihan_jawaban = new String []{
            "1 : 1","2 : 1","2 : 3","4 : 3",
            "0,1 × 10–19 joule","0,16 × 10–19 joule","1,6 × 10–19 joule","3,2 × 10–19 joule",
            "mengurangi tebal katode dan memperbesar intensitas cahaya","memperbesar panjang gelombang dan memperbesar intensitasnya","mengurangi tebal katode dan memperbesar panjang gelombang","memperbesar frekuensi cahaya sampai frekuensi batas dan memperbesar intensitasnya",
            "2 × 10–19 joule","4 × 10–19 joule","6 × 10–19 joule","9× 10–19 joule",
            "1,32 × 10–19 joule","1,372 × 10–19 joule","1,23 × 10–19 joule","2,32 × 10–19 joule",
            "0,34","0,55","0,66","0,77",
            "1,33 m","0,03 m","0,08 m","0,75 m",
            "nol","0,08 N","0,5 N","2 N",
            "0,02","0,03","0,05","0,06",
            "0,25 ampere","2,5 ampere","3,5 ampere","3 ampere",
    };
    String[] jawaban_benar = new String[]{
            "4 : 3",
            "0,1 × 10–19 joule",
            "memperbesar frekuensi cahaya sampai frekuensi batas dan memperbesar intensitasnya",
            "2 × 10–19 joule",
            "1,32 × 10–19 joule",
            "0,66",
            "0,03 m",
            "nol",
            "0,03",
            "2,5 ampere",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_fis);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisFis1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
