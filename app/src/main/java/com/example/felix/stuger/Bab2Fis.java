package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Fis extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Dua kawat sejajar lurus panjang berjarak 20 cm satu sama lain. Apabila kedua kawat dialiri arus listrik 0,5 A dan 4 A, dan µo = 4π .10–7 Wb.A–1.m–1 maka pada setiap kawat bekerja gaya tiap meternya sebesar... ",
            "2.Dua kawat sejajar yang berjarak 1 m satu sama lain kawat yang mempunyai dialiri oleh arus listrik masing-masing 1 A dengan arah yang sama. Di antara kedua kawat akan terjadi …  ",
            "3.Sebuah kawat yang panjangnya 10 cm berada tegak lurus di dalam medan magnetik. Jika rapat fluks magnetiknya 0,2 tesla dan kuat arus yang mengalir di dalam kawat itu 45 A, gaya yang dialami kawat itu adalah...",
            "4.Tiga kapasitor yang masing-masing kapasitasnya 3 F, 6 F, dan 9 F dihubungkan seri. Kedua ujung dari gabungan tersebut dihubungkan dengan sumber tegangan yang besarnya 220 V. Tegangan antara ujung-ujung kapasitor yang 3 F adalah.... ",
            "5.Panjang gelombang cahaya yang dipancarkan oleh lampu monokromatis 100 watt adalah 5,5.10−7 m. Cacah foton (partikel cahaya) per sekon yang dipancarkan sekitar.... ",
            "6.Sebuah palu jatuh dari sebuah kamar pada gedung bertingkat dan sampai di tanah dalam waktu 2  detik. Ketinggian kamar itu adalah……",
            "7.Sebuah peti didorong oleh gaya horizontal sebesar 40 N hingga bergeser sejauh 2 m. Usaha yang dilakukan terhadap peti adalah ..",
            "8.Banyaknya kalor yang diperlukan untuk menaikkan suhu 2 kg air dari 50 C menjadi 250C, jika kalor jenis air 4.200 j/kg0c adalah ……",
            "9.Seekor ikan berada pada dasar akuarium penuh air yang tingginya 25 cm. Jika massa jenis air 1.00 kg/m3, Tekanan hidrostatis ikan tersebut adalah …",
            "10.Sebuah mesin karnot bekerja pada suhu reservoir antara 300 K dan 750 K, efisiensi mesin tersebut adalah......."
    };
    String[] pilihan_jawaban = new String []{
            "2 × 10–6 N","4 × 10–6 N","2π × 10–6 N","8 × 10–6 N",
            "Gaya tarik menarik sebesar 4×107 N","Gaya tolak menolak sebesar 2×107 N","Gaya tarik menarik sebesar 2×10–7 N","Gaya tolak menolak sebesar 2×10–7 N",
            "10,5 x 10−4 N","2,55 x 10−2 N","2,25 N","0,90 N",
            "40 V","60 V","120 V","150 V",
            "2,8 x 1022 /s","2,0 x 1022 /s","2,8 x 1020 /s","2,6 x 1020 /s",
            "15 m","20 m","25 m","30 m",
            "45 J","34 J","54 J","80 J",
            "168.000 J","150.000 J","250.000 J","125.000 J",
            "5000 Pa","3500 Pa","3000 Pa","2500 Pa",
            "60%","80%","20%","70%",
    };
    String[] jawaban_benar = new String[]{
            "2 × 10–6 N",
            "Gaya tarik menarik sebesar 2×10–7 N",
            "0,90 N",
            "120 V",
            "2,8 x 1020 /s",
            "20 m",
            "80 J",
            "168.000 J",
            "2500 Pa",
            "60%",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_fis);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisFis2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
