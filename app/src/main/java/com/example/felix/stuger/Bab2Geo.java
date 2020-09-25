package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Geo extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Sebuah ruangan dengan panjang 6 m, lebar 4 m, dan tinggi 3 m. Pada suhu 20ºC ruangan tersebut dapat menampung uap air maksimum sebanyak 60 gr/m3, pada saat pengukuran terdapat uap air sebanyak 1080 g. Maka kelembaban nisbi udara pada ruangan tersebut adalah ....",
            "2.Daerah yang termasuk persebaran fauna wilayah paleartik meliputi Afrika bagian utara, Eropa,   Asia tengah, dan Jepang. Contoh fauna yang terdapat di wilayah tersebut adalah ....",
            "3.Salah satu fauna Indonesia yang berada di wilayah peralihan dan belakang ini diperdebatkan oleh banyak pihak karena dianggap sebagai salah satu keajaiban dunia adalah ....",
            "4.Data penduduk Kota Sukasari tahun 2010 :\n" +
                    "-    jumlah penduduk = 12.200\n" +
                    "-    laju pertumbuhan = 2,4 % per tahun\n" +
                    "Dengan laju pertumbuhan penduduk tetap, maka jmulah penduduk Kota Sukasari pada tahun 2020 sebanyak ....\n",
            "5.Pemanfaatan lahan yang memiliki kemiringgan lereng 55%,  untuk kegiatan pertanian agar kesuburan tanah tetap terjaga dilakukan dengan cara ....",
            "6.Pembangunan suatu proyek seperti pabrik harus terlebih dahulu dilakukan analisis dampak lingkungan, yang dikenal dengan AMDAL dengan tujuan ....",
            "7.Pembangunan berkelanjutan dapat dicapai dengan pembangunan berwawasan lingkungan, karena dengan demikian kondisi lingkungan dapat memberikan daya dukung maksimum. Yang dimaksud dengan pembangunan berkelanjutan adalah pembangunan yang ....",
            "8.Peta 1 memiliki skala 1 : 2000.000 dengan jarak A_B = 2 cm, dan pada peta 2, yang tidak meiliki skala, jarak A-B = 4 cm, maka skala peta 2 adalah ",
            "9.Letak astronomis wilayah Indonesia yang berada pada  95o BT – 141o BT dan 6o LU -11o LS, Proyeksi peta yang sesuai untuk menggambarkan wilayah negara Indonesia adalah menggunakan proyeksi ….",
            "10.Komponen Sistem Informasi Geografi (SIG) berupa software, memiliki fungsi:"
    };
    String[] pilihan_jawaban = new String []{
            "15%","25%","35%","45%",
            "Unta dan Gajah","Bison dan Badak","Kura-kura dan Rainder","Kelinci dan Tikus",
            "anoa","gajah","burung maleo","komodo",
            "15.372","15.273","14.361","14.365",
            "membuat terasering","membajak searah dengan kemiringan lereng","menanam tanaman yang berusia muda","ladang berpindah-pindah",
            "menghilangkan dampak negatif akibat pembangunan bagi masyarakat","agar pembangunan memberikan dampak ekonomi bagi masyrakat","agar pengusaha berhati-hati dalam pembangunan proyek","memperkecil dampak negatif yang ditimbulkan pembangunan terhadap lingkungan",
            "dapat memenuhi kebutuhan masyarakat banyak","tidak berdampak negatif pada lingkungan","dapat meningkatkan penghasilan masyarakat","dapat memenuhi kebutuhan generasi kini dan mendatang",
            "1 : 400.000","1 : 800.000","1 : 1.000.000","1 : 4.000.000",
            "zenithal oblique","silinder equator","kerucut oblique","silinder oblique",
            "menayangkan hasil pemrosesan oleh CPU","verifikasi, penyimpanan, analisis dan transformasi data","mencetak peta yang berukuran besar","mengubah data terestrial menjadi data digital",
    };
    String[] jawaban_benar = new String[]{
            "25%",
            "Kelinci dan Tikus",
            "komodo",
            "15.372",
            "membuat terasering",
            "memperkecil dampak negatif yang ditimbulkan pembangunan terhadap lingkungan",
            "dapat memenuhi kebutuhan generasi kini dan mendatang",
            "1 : 1.000.000",
            "silinder equator",
            "verifikasi, penyimpanan, analisis dan transformasi data"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_geo);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisGeo2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
