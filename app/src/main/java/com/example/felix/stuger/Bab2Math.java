package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Math extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1. Dari suatu barisan geometri diketahui suku ke-2 adalah dan suku ke-5 adalah 36 suku ke-6 barisan tersebut adalah….",
            "2.Diketahui segitiga siku-siku sama kaki pertama dengan panjang sisi siku-sikunya. Dibuat segitiga siku-siku sama kaki ke-2 dengan panjan sisi miring sama dengan panjang sisi siku-siku segitiga pertama. Segitiga siku-siku sama kaki ke-3, ke-4 dan seterusnya masing-masing dibuat dengan panjang sisi miring sama dengan pajag sisi siku-siku segitiga sebelumnya . Jumlah luas seluruh segitiga adalah….",
            "3.Seorang petani menyemprotkan obat pembasmi hama pada tanamannya. Reaksi obat tersebut jam setelah disemprotkan dinyatakan dengan rumus f(t) = 15t 2 – t 3. Reaksi maksimum tercapai setelah...",
            "4.Persamaan kuadrat yang akar-akarnya kebalikan dari akar-akar persamaan 2x2-3x +5 = 0 adalah..",
            "5.Seorang murid diminta mengerjakan 5 dari 7 soal ulangan, tapi soal nomor 1 dan 2 harus dikerjakan. Banyaknya pilihan yang dapat diambil murid tersebut adalah….",
            "6.Perbandingan panjang dan lebar persegi panjang adalah 4 : 3. Jika kelilingnya 84 cm, luasnya adalah….",
            "7.Perhatikan pola bilangan berikut ini!\n" +
                    "\n" +
                    "24, 12, 36, 18, 54…, …\n" +
                    "\n" +
                    "Tentukan bilangan ke-6 dan ke-7 dari pola di atas!",
            "8.Anis membeli sebuah telfon genggam dengan harga Rp1.800.000,00, setelah pemakaian 3 bulan Anis menjual dengan harga Rp1.200.000,00. Berapa persentase kerugian yang dialami oleh Anis?",
            "9.Diberikan P = {1,2,3,4,5,6,7,8,9}. Himpunan bilangan ganjil yang terdapat di P adalah....",
            "10.Umur Ibu 4 tahun lebih muda dari umur Ayah. Jumlah umur Ibu dan Ayah adalah 78 tahun. Berapakah umur Ayah sekarang?"
    };
    String[] pilihan_jawaban = new String []{
            "108","54","48","20",
            "4","5","7","8",
            "3 jam","5 jam","10 jam","7 jam",
            "2x2 -5x +3 = 0","2x2 +3x +5 = 0","3x2 -2x +5 = 0","5x2 -3x +2 = 0",
            "5","10","12","145",
            "234 cm2","324 cm2","432 cm2","452 cm2",
            "22 dan 17","27 dan 18","27 dan 81","81 dan 27",
            "23%","33%","34%","35%",
            "{1,2,3,7}","{2,4,8,9}","{1,3,5,7,9}","{1,5,7,9}",
            "30","37","50","41",
    };
    String[] jawaban_benar = new String[]{
            "108",
            "5",
            "10 jam",
            "5x2 -3x +2 = 0",
            "10",
            "432 cm2",
            "27 dan 81",
            "33%",
            "{1,3,5,7,9}",
            "41"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_math);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisMath2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
