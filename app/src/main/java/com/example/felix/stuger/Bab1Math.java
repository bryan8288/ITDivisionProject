package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Math extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Misalkan α dan β adalah akar-akar persamaan 2x2 - x – 5 = 0. Persamaan kuadrat baru yang akar-akarnya 2α + 1 dan 2β + 1 adalah….",
            "2.Tempat parkir seluas 500 m2 hanya mampu menampung 30 bus dan mobil. Tiap mobil membutuhkan tempat seluas 5 m2 dan bus menempati 25 m2. Model matematika yang memenuhi persamaan tersebut adalah….",
            "3.Harga tiket kelas I dalam final Piala Presiden 2018 adalah Rp500.000,00. Panitia menyediakan 8 baris untuk kelas I, dengan rincian pada baris pertama terdapat 8 kursi, baris kedua 10 kursi, pada baris ketiga 12 kursi dan seterusnya. Jika kursi terisi semua pada kelas tersebut, maka pendapatan yang diterima dari kelas I adalah....",
            "4.Nilai dari\n" +
                    "2\n" +
                    "log 4 +\n" +
                    "2\n" +
                    "log 12\n" +
                    " – \n" +
                    " \n" +
                    "2\n" +
                    "log 6 =...",
            "5.Jika log 3 = 0,4771 dan log 2 = 0,3010, maka nilai dari log 75 =...",
            "6. Dalam skala Richter, kekuatan  R dari suatu gempa bumi dengan intensitas I dimodelkan dengan, di mana I 0  = 1 merupakan intensitas minimum yang digunakan untuk perbandingan. Intensitas masing-masing gempa bumi berikut adalah….",
            "7.Jika selisih akar-akar persamaan sama dengan 5 , maka jumlah akar-akar persamaan adalah….",
            "8.Himpunan penyelesaian dari x + 2y = -3, y + 2z = 4, dan x + y + 2z = 5 adalah {(x,y,z)} . Nilai dari x + z adalah…",
            "9.Diketahui matrik C Nilai x + y yang memenuhi A + B = C adalah ….",
            "10.Suatu perusahaan pada tahun pertama memproduksi 5000 unit barang, pada tahun-tahun berikutnya produksinya turun secara tetap sebesar 80 unit per tahun .Perusahaan tersebut akan memproduksi 3000 unit barang pada tahun ke…"
    };
    String[] pilihan_jawaban = new String []{
            "x2 – 4x – 21 = 0","x2 – 4x – 19 = 0","x2 – 4x + 20 = 0","x2 – 3x – 8 = 0",
            "x+y<=30,x+5y<=100,x>=0,y>=0","x+y<=20,x+5y<=220,x>=0,y>=0","x+y<=10,x+5y<=150,x>=0,y>=0","x+y<=30,x+5y<=200,x>=0,y>=0",
            "Rp60.000.000,00","Rp70.000.000,00","Rp80.000.000,00","Rp85.000.000,00",
            "8","3","2","5",
            "0,7781","0,9209","1,0791","1,8751",
            "316.000.000","31.600.000","3.160.000","316.000",
            "11 atau -11","9 atau -9","8 atau -8","7 atau -7",
            "5","4","1","-1",
            "5","3","-5","1",
            "24","25","26","27",
    };
    String[] jawaban_benar = new String[]{
            "x2 – 3x – 8 = 0",
            "x+y<=30,x+5y<=100,x>=0,y>=0",
            "Rp60.000.000,00",
            "3",
            "1,8751",
            "316.000.000",
            "11 atau -11",
            "1",
            "5",
            "26"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_math);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisMath1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
