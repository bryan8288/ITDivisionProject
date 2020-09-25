package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab3Bio extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Alga dapat diklasifikasikan berdasarkan…",
            "2.Chlorella merupakan salah satu alga yang cukup memperoleh perhatian para ahli sebagai sumber makanan baru, karena mengandung protein dan amilum cukup tinggi. Organisme ini termasuk…",
            "3.Pigmen yang didominasi berupa fukosantin terdapat pada…",
            "4.Protozoa dapat diklasifikasikan berdasarkan..",
            "5.Penyakit malaria disebabkan oleh anggota dari Protozoa, yaitu…",
            "6.Salah satu peranan Phytoflagellata dalam ekosistem perairan adalah…",
            "7.Jamur Rhizopus oryzae dapat dimanfaatkan untuk membuat ....",
            "8.Dinding sel pada jamur Zygomycota mengandung zat ....",
            "9.Kacang tanah yang ditumbuhi jamur hendaknya dibuang, karena telah mengandung aflatoksin yang dihasilkan oleh ….",
            "10.Bentuk interaksi antara Mycoriza dengan akar tanaman merupakan bentuk simbiosis ….",
    };
    String[] pilihan_jawaban = new String []{
            "Bentuk tubuh","Struktur selnya","Kandungan pigmen yang dominan","Kandungan klorofil",
            "Alga Hijau","Alga Merah","Alga biru","Alga coklat",
            "Chlorophyta","Phaeophyta","Rhodophyta","Chrysophyta",
            "Struktur tubuh","Ada tidaknya pigmen","Adanya pirenoid","Alat gerak",
            "Trypanosoma","Leishmanis","Plasmodium","Balantidium",
            "Zooplankton","Phytoplankton","Decomposer","Detrivor",
            "oncom merah","antibiotik","tape","tempe",
            "sitokitin","kitin","fiositin","selulosa",
            "Peniscilium sp","Fusarium sp","Aspergilus flavus","Roselinia sp",
            "Parasitisme","Mutualisme","Komensalisme","netralisme",
    };
    String[] jawaban_benar = new String[]{
            "Kandungan pigmen yang dominan",
            "Alga Hijau",
            "Phaeophyta",
            "Alat gerak",
            "Plasmodium",
            "Detrivor",
            "tempe",
            "kitin",
            "Aspergilus flavus",
            "Mutualisme",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_bio);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisBio3.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
