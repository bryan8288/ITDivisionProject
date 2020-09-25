package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab3Sos extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Salah satu faktor pendorong terjadinya mobilitas sosial yang berkaitan dengan aspek geografis adalah ...",
            "2.Faktor penyebab adanya primordialisme adalah ...",
            "3.Kemajemukan masyarakat Indonesia secara historis terdiri dari berbagai suku bangsa. Hal ini dilatarbelakangi oleh ...",
            "4.Di antara karya bangsa Indonesia yang dapat dijadikan tali pengikat Indonesia yang mejemuk ...",
            "5.Kemajemukan masyarakat Indonesia dalam kehidupan keagamaan dilatarbelakangi oleh kenyataan yaitu ...",
            "6.Berkembangnya paham tradisional dalam kehidupan masyarakat majemuk, seperti usaha membentuk perkumpulan atas dasar tempat kelahiran, suku bangsa, agama, maupun kekerabatan, merupakan gejala sosial yang menunjukkan ...",
            "7.Munculnya politik aliran dalam masyarakat, menyebabkan munculnya organisasi yang berdasarkan ...",
            "8.Pengaruh kemajemukan masyarakat Indonesia dapat mengakibatkan konflik apabila ...",
            "9.Sebagian masyarakat Indonesia beranggapan bahwa kebudayaan Barat lebih tinggi daripada kebudayaan sendiri dan modernisasi tidak lain proses meniru budaya Barat. Penyebab sikap yang keliru tersebut adalah ...",
            "10.Contoh perubahan yang berbentuk progres adalah ..."
    };

    String[] pilihan_jawaban = new String []{
            "Perubahan standar hidup","Perubahan tingkah laku","Perbedaan jenis kelamin","Perubahan lingkungan alam",
            "Kesetiaan terhadap sesuatu yang dimiliki sejak lahir","Fanatisme yang berlebihan dan meremehkan budaya asing","Sikap tertutup terhadap budaya asing karena rasa curiga",". Letak yang terisolasi sehingga tidak terpengaruh budaya asing",
            "Isolagi geografis dan kepulauan","Keragaman budaya dan potensi alam","Penjajahan migrasi penduduk","Perdagangan dan kekayaan alam",
            "Bahasa Indonesia dan ideologi Pancasila","Partai politik","Angkatan bersenjata yang kuat","Perguruan tinggi di berbagai daerah",
            "Letak geografis dan persimpangan lalu lintas dunia","Ideologi negara dengan kebebasan negara","Ideologi negara dengan kebebasan negara","Perbedaan adat istiadat antar kelompok sosial",
            "Etnosentrisme","Politik aliran","Organisasi politik","Promordialisme",
            "Kebangsaan","Pendidikan","Perubahan","Keagamaan",
            "Semangat kebangsaan anggota masyarakat lemah","Para pemimpin kurang akomodatif dan responsif","Moral masyarakat tidak berdasarkan agama","Banyak tergantung pada kemampuan bangsa lain",
            "Masyarakat Indonesia lebih terbuka","Kurang memahami makna modernisasi","Kurang kreatif dalam menemukan penemuan baru","Menggunakan produk asing meningkatkan status sosial",
            "Listrik masuk desa menyebabkan kenakalan remaja","Siaran televisi menyebabkan murid malas belajar","Banyak wanita berpakaian sangat minim","Penemuan komputer memperlancar sistem informasi",
    };

    String[] jawaban_benar = new String[]{
            "Perubahan lingkungan alam",
            "Kesetiaan terhadap sesuatu yang dimiliki sejak lahir",
            "Keragaman budaya dan potensi alam",
            "Bahasa Indonesia dan ideologi Pancasila",
            "Letak geografis dan persimpangan lalu lintas dunia",
            "Etnosentrisme",
            "Keagamaan",
            "Semangat kebangsaan anggota masyarakat lemah",
            "Kurang memahami makna modernisasi",
            "Siaran televisi menyebabkan murid malas belajar"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_sos);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisSos3.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
