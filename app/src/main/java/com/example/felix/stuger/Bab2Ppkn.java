package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Ppkn extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Pancasila merupakan gambaran tertulis dari pola sikap, perilaku serta perbuatan bangsa indonesia yang khas dan membedakan dengan bangsa lain. Pernyataan tersebut merupakan kedudukan atau fungsi pancasila sebagai...",
            "2.Pancasila sebagai dasar negara dipergunakan untuk.....",
            "3.Pancasila menjadi tuntunan bagi penyelenggaraan pemerintah dan kenegaraan RI merupakan fungsi Pancasila sebagai........",
            "4.Pancasila sebagai jiwa kepribadian bangsa tercermin dalam......",
            "5.Pancasila sebagai pedoman sikap dan perilaku sehari hari masyarakat Indonesia merupakan pengamalan Pancasila sebagai......",
            "6.Pancasila sebagai nilai-nilai luhur bangsa Indonesia adalah...",
            "7.Pancasila telah berperan dan berfungsi mempersatukan seluruh rakyat Indonesia yang multi etnis, multi ideologi dan multi religius atau majemuk.Dalam hal ini pancasila dihayati sebagai.......",
            "8.Pada ideologi yang terbuka salah satunya mengandung esensi dimensi realita,karena....",
            "9.Ideologi Pancasila memiliki keluwesan yang memungkinkan dan bahkan merangsang pengembangan pemikiran-pemikiran baru yang relevan tanpa menghilangkan hakikat jati diri yang terkandung dalam nilai-nilai dasarnya.Pernyataan tersebut adalah pengertian ideologi Pancasila dari dimensi...",
            "10.Salah satu ciri dari pada ideologi terbuka apabila dalam ideologi tersebut memiliki unsur....."
    };
    String[] pilihan_jawaban = new String []{
            "Kepribadian Bangsa","Ideologi","Dasar negara","Pandangan hidup",
            "Dasar dalam mengatur penyelenggaraan pemerintahan negara","Menentukan tujuan negara","Menyusun program – program pembangunan","Landasan kehidupan berbangsa dan bernegara",
            "Dasar Negara","Pandangan hidup bangsa","Satu-satunya azas yang cocok untuk bangsa Indonesia","Jiwa dan kepribadian bangsa Indonesia",
            "Tata urutan perundang-undangan","Nilai nilai yang dimiliki bangsa Indonesia","Proses terbentuknya negara Indonesia","Bentuk dan susunan ketatanegaraan",
            "Dasar negara","Sumber tertib hukum negara RI","Pandangan hidup bangsa Indonesia","Asas dan dasar negara Indonesia",
            "Pendirian atau sikap bangsa mengenai kehidupan","Ciri khas kehidupan bangsa Indonesia","Cita-cita moral bangsa bangsa Indonesia","Jiwa bangsa Indonesia",
            "Ideologi persatuan","Ideologi terbuka","Ideologi rakyat","Ideologi kebangsaan",
            "Nilai-nilai yang ada bersumber dari budaya dan pengalaman sejarahnya","Semua nilai-nilai yang diyakini benar bersumber dari kultural masyarakat","Semua ide dan gagasan yang ada bersumber dari masyarakat sekitar","Tumbuhnya nilai-nilai yang ada berhubungan dengan masyarakat sekitar",
            "Realita","Fleksibilitas","Substansi","idealisme",
            "Statis","Kekal","Tetap","Fleksibilitas",
    };
    String[] jawaban_benar = new String[]{
            "Kepribadian Bangsa",
            "Dasar dalam mengatur penyelenggaraan pemerintahan negara",
            "Dasar Negara",
            "Nilai nilai yang dimiliki bangsa Indonesia",
            "Pandangan hidup bangsa Indonesia",
            "Pendirian atau sikap bangsa mengenai kehidupan",
            "Ideologi kebangsaan",
            "Semua nilai-nilai yang diyakini benar bersumber dari kultural masyarakat",
            "Realita",
            "Fleksibilitas"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_ppkn);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisPpkn2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
