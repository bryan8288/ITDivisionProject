package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Geo extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Keterkaitan antara fenomena geosfer yang satu dengan fenomena yang lain di permukaan bumi, dapat di pelajari dengan menggunakan .... ",
            "2.Peristiwa tanah longsor yang terjadi di Jawa Barat pada bulan Nopember 2011 merupakan akibat dari pembalakan liar yang memakan korban jiwa, konsep geografi yang berkaitan dengan kasus tersebut adalah ....",
            "3.Nelayan memanfaatkan angin darat pergi ke laut pada malam hari untuk menangkap ikan, dan pulang  kembali  ke  darat  memanfaatkan  angin laut, kegiatan para nelayan tersebut menyangkut ....",
            "4.Gagal panen padi yang terjadi di Pulau Jawa akibat pengairan yang tidak merata, karena  ketika musim hujan air sungai meluap dan pada musim kemarau mengalami kekeringan. Pendekatan geografi dapat digunakan untuk memecahkan masalah tersebut adalah ",
            "5.Peristiwa yang terjadi pada batas lempeng A dan B seperti pada gambar berikut adalah ....",
            "6.Tata Surya terbentuk dari hasil gaya grafitasi antara matahari dan bintang yang melintas dekat matahari merupakan isi teori ....",
            "7.Yang termasuk dalam kelompok negara maju adalah .... ",
            "8.Pernyataan  !\n" +
                    "(1)    memiliki satelit Europa, Ganymeda dan Callisto \n" +
                    "(2)    memiiki atmosfer yang sangat pekat dan memilliki cincin\n" +
                    "(3)    kala revolusi selama 11,86 tahun bumi\n" +
                    "(4)    memiliki kala revolusi 365,25 hari\n" +
                    "(5)    letaknya paling dekat dengan matahari\n" +
                    "\n" +
                    "Dari pernyataan tersebut yang merupakan karakteristik planet Yupiter ditunjukkan  nomor ....\n",
            "9.Menurut teori kontraksi kerak bumi mengalami pengkerutan sehingga permukaan bumi tidak rata, hal ini disebabkan oleh ....  ",
            "10.Ciri ekonomis negara berkembang di kawasan Asia Tenggara seperti Indonesia, Malaysia, Myanmar, Kamboja adalah ."
    };
    String[] pilihan_jawaban = new String []{
            "prinsip interelasi","prinsip distribusi","prinsip korologi","prinsip deskripsi",
            "konsep morfologi","konsep interaksi","konsep lokasi","konsep jarak",
            "aspek sosial","aspek budaya","aspek fisis","aspek keruangan",
            "pendekatan keterjangkauan","pendekatan kelingkungan","pendekatan kompleks wilayah","pendekatan keruangan",
            "penunjaman lempeng","dua lempeng saling menjauh","pusat gempa dalam ","pusat gempa dangkal",
            "Pasang surut","Bintang kembar","Planetesimal","Protoplanet",
            "Colombia dan Argentina","Peru dan Mexico","Kanada dan Jepang","Mexico dan Kanada",
            "(1) dan (3)","(2) dan (4)","(3) dan (5)","(4) dan (5)",
            "Bumi mengalami proses pemadatan ","Bumi berotasi yang menyebabkan pemepatan","Bumi di timpa oleh benda-benda langit yang jatuh","Bumi mengalami pendinginan akibat konduksi panas",
            "Pertumbuhan penduduk tinggi","Komposisi penduduk berupa piramida tua","Tingkat pendidikan penduduk tinggi","Kegiatan ekonomi disektor pertanian",
    };
    String[] jawaban_benar = new String[]{
            "prinsip interelasi",
            "konsep interaksi",
            "aspek fisis",
            "pendekatan keruangan",
            "pusat gempa dangkal",
            "Pasang surut",
            "Kanada dan Jepang",
            "(1) dan (3)",
            "Bumi mengalami pendinginan akibat konduksi panas",
            "Kegiatan ekonomi disektor pertanian"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_geo);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisGeo1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
