package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab3Kim extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Zat yang tidak dapat diuraikan lagi menjadi zat yang lebih sederhana melalui reaksi kimia biasa disebut...",
            "2.Ilmuwan yang berhasil menemukan elektron dan model atom yang menyerupai roti kismis adalah...",
            "3.Sebuah atom memiliki jumlah elektron 7 dan nomor massanya 19. Berapakah jumlah neutron pada atom tersebut?",
            "4.Dalam satu golongan, besarnya jari-jari atom dari atas ke bawah adalah...",
            "5.Sifat-sifat unsur yang berubah secara beraturan seiring pertambahan nomor atomnya disebut...",
            "6.Suatu ikatan dimana pasangan elektron yang dipakai bersama tertarik lebih kuat ke salah satu atom disebut..",
            "7.Ikatan kimia pada senyawa air adalah jenis ikatan...",
            "8.Dibawah ini merupakan senyawa yang memiliki ikatan homopolar, kecuali...",
            "9.25 gram gas CO2 yang diukur pada keadaan standar memiliki volume sebesar... ",
            "10.Jika Ar H=1, O=16, dan C=12. Maka dalam 0,50 mol H2CO3 terdapat unsur C sebanyak..."
    };
    String[] pilihan_jawaban = new String []{
            "unsur","molekul","senyawa","atom",
            "Niels Bohr","Ernest Rutherford","J.J Thomson","J. Chadwik",
            "7","19","12","14",
            "Berkurang","Bertambah","Tetap","Mengecil",
            "Sifat golongan","Sifat unsur","Sifat khas","Sifat periodik",
            "Ikatan ion","Ikatan kovalen polar","Ikatan van der Wals","Ikatan logam",
            "Ikatan hidrogen","Ikatan logam","Ikatan ion","Ikatan kovalen",
            "NaOH","HCI","HCL","HF",
            "22,4 L","11,2 L","12,5 L","12,7 L",
            "12 gram","1 gram","6 gram","31 gram",
    };
    String[] jawaban_benar = new String[]{
            "unsur",
            "J.J Thomson",
            "12",
            "Bertambah",
            "Sifat periodik",
            "Ikatan kovalen polar",
            "Ikatan hidrogen",
            "NaOH",
            "11,2 L",
            "6 gram",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_kim);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisKim3.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
