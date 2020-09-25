package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab3Ppkn extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Diantara pernyataan berikut yang bukan ciri  ideologi tertutup adalah......",
            "2.Semua pernyataan berikut adalah ciri-ciri ideologi terbuka, kecuali.....",
            "3.Demokrasi Pancasila bersumber pada....",
            "4.Ideologi komunisme bertentangan dengan nilai – nilai Pancasila karena komunis mengajarkan.....",
            "5.Berikut ini yang bukan upaya mempertahankan ideologi negara....",
            "6.Melaksanakan Pancasila dan UUD 1945 secara murni dan konsekuen adalah tekad dari...",
            "7.Bangsa Indonesia sejak dahulu telah terbiasa hidup dalam alam yang beraneka ragam teruma dalam hal....",
            "8.Pancasila sebelum menjadi falsafah dan dasar negara nilai – nilai dasarnya telah ada dan berasal dari bangsa Indonesia yaitu....",
            "9.Keunggulan ideologi Pancasila akan dapat dirasakan dalam realita kehidupan bangsa Indonesia apabila telah diamalkan oleh....",
            "10.Demokrasi Pancasila Dalam menyelesaikan masalah yang menyangkut kepentingan bersama lebih mengedepankan cara..."
    };
    String[] pilihan_jawaban = new String []{
            "Merupakan cita-cita yang sudah hidup dalam masyarakat","Mencakup / mengurusi semua bidang kehidupan","Pluralisme pandangan dan kehidupan ditiadakan","Menuntut masyarakat untuk memiliki kesetiaan total",
            "Merupakan kesepakatan masyarakat","Milik seluruh rakyat, dan bisa digali dan ditemukan dalam kehidupan mereka","Isinya bersifat langsung operasional dan mudah diterapkan","Menghargai pluralitas budaya dan agama",
            "Kehidupan bangsa Indonesia","Budaya bangsa Indonesia","Hukum adat Indonesia","Peraturan negara RI",
            "Atheis","Individualisme","Sosialisme","Nasionalisme",
            "Menjalankan nilai Pancasila dalam kehidupan sehari – hari","Mengajarkan Pancasila disekolah – sekolah","Mengamalkan Pancasila sesuai dengan keinginannya","Menjabarkan Pancasila sesuai keinginannya",
            "Rakyat Indonesia","Pemerintah","Orde Baru","Golongan Komunis",
            "Kepercayaan yang dianut","Ideologi yang dianut","Pekerjaan yang dilakukan","Kiblat politik yang diakui",
            "Ajaran nenek moyang sejak dahulu kala","Adat istiadat, kebudayaan dan nilai – nilai religius","Cerita pewayangan yang menjadi kebudayaan","Sejarah kehidupan masa lalu",
            "Pemerintah selaku penyelenggara negara","Presiden dan kabinetnya","Rakyat yang duduk di pemerintahan","Seluruh Rakyat Indonesia",
            "Harus menyelesaikan melalui jalur hukum","Menyelesaikan secara kekeluargaa","Menyerahkan kepada yang berwajib","Musyawarah mufakat",
    };
    String[] jawaban_benar = new String[]{
            "Merupakan cita-cita yang sudah hidup dalam masyarakat",
            "Milik seluruh rakyat, dan bisa digali dan ditemukan dalam kehidupan mereka",
            "Budaya bangsa Indonesia",
            "Atheis",
            "Menjabarkan Pancasila sesuai keinginannya",
            "Orde Baru",
            "Kepercayaan yang dianut",
            "Ajaran nenek moyang sejak dahulu kala",
            "Seluruh Rakyat Indonesia",
            "Musyawarah mufakat"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_ppkn);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisPpkn3.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
