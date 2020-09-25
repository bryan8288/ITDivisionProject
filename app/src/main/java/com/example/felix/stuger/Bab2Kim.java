package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Kim extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Jika 50 mL larutan CH3COOH 0,1M (Ka= 106-) dicampur dengan 50 mL Larutan NaOH 0,1 M maka ph campuran yang terbentuk adalah… ",
            "2.Jika kelarutan senyawa AgCl dalam air murni adalah 10-5M, maka kelarutan AgCl dalam larutan AgNO3 0,1M adalah...",
            "3.Dua gram suatu zat elektrolit biner dilarutkan dalam 500 gram air.  Ternyata larutan tersebut membeku pada suhu -0,3720C, Jika Kf air= 1,86  maka Mr senyawa tersebut adalah… ",
            "4. Sebanyak 1,27 gram zat elektrolit LCl2 pada 270C dilarutkan dalam air sampai volume 500mL .  tekanan osmosis larutan = 1,476 atm dan R = 0,082, maka Mr zat elektrolit tersebut adalah… ",
            "5. Koloid Fe(OH)2 dibuat dengan mencampurkan larutan besi (III) klorida ke dalam air panas.  Pembuatan koloid sperti itu dikenal dengan cara reaksi..",
            "6. Diantara reaksi berikut ini yang merupakan reaksi redoks adalah… ",
            "7. Proses elektrolisis merupakan reaksi redoks yang tidak spontan.  Energi yang digunakan pada proses elektrolisis berasal dari arus listrik searah.  Pada proses elektrolisis larutan CuSO4 dengan electrode tembaga, maka reaksi yang berlangsung pada elektroda Katoda adalah… ",
            "8.Arus sebesar 5 amper dialirkan ke dalam alrutan AgNO3 selama 193 detik.  Maka massa zat yang terbentuk di katoda sebanyak…(ArH=1, Ag=108, O=16, N=14) 1F =  96500C ",
            "9. Arus yang sama dialirkan ke dalam larutan AgNO3 dan larutan CuSO4 apabila massa Ag yang diendapkan adalah 1,08 gram, maka massa Cu yang mengendap (Ar Cu= 63,5, Ar Ag= 108) adalah…. ",
            "10.Urutan daya pengoksidasi (Oksidator) unsure unsure periode 3 dari kuat ke lemah adalah… "
    };
    String[] pilihan_jawaban = new String []{
            "5 – log 2,24","5 + log  2,24","9 + log 2,24","9 - log 2,24",
            "10-9M","10-8M","10-6M","10-7M",
            "20","30","40","60",
            "127","172","285","258",
            "pendesakan","Hidrolisis","Oksidasi","Reduksi",
            "NaCl + H2O   ---->  NaOH  +  HCl","CaSO4+ 2NaOH  ---->    Na2SO4 +  Ca(OH)2","BaCl2 +  H2SO4    ---->     BaSO4  +  2HCl","MnO2 + 4HCl   ----->    MnCl2 + 2H2O + Cl2",
            "Cu    ----->   Cu2+  +  2e ","2H2O   ----->   4H+ +  4e  + O2 ","2H+  +  2e   ---->  H2","Cu2+  +  2e   ---->   Cu",
            "0.1 gram","0.2 gram","1,08 gram","1,02 gram",
            "6.35 gram","3,175 gram","0,3175 gram","0,3275 gram",
            "S, P, Si","Si , S, P","P, S, Si","Si, P, S",
    };
    String[] jawaban_benar = new String[]{
            "9 + log 2,24",
            "10-9M",
            "40",
            "127",
            "Hidrolisis",
            "MnO2 + 4HCl   ----->    MnCl2 + 2H2O + Cl2",
            "Cu2+  +  2e   ---->   Cu",
            "1.08 gram",
            "0,3175 gram",
            "S, P, Si"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_kim);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisKim2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
