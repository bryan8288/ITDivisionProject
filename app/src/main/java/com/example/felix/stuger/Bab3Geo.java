package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab3Geo extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Analisis Sistem Informasi Geografi (SIG) dengan cara menggabungkan beberapa peta tematik untuk menghasilkan peta yang baru, adalah ....",
            "2.Pemanfaatan Sistem Informasi Geografi (SIG) dalam bidang pertanian adalah ....",
            "3.Karakteristik wilayah desa dengan pola pemukiman seperti pada gambar berikut adalah ....",
            "4.Penduduk kota A = 5.000.000 jiwa,  penduduk kota B  = 2.500.000 jiwa Jika jarak antara kota A dan B sejauh 50 km. Maka lokasi titik henti antara kota A dan kota B berada ....",
            "5.Pada tahun 2006 di Indonesia terjadi peristiwa bencana Lumpur Panas Lapindo yang mengakibatkan masyarakat di sekitar daerah tersebut mengalami kerugian moril maupun materil. Proses kejadian bencana tersebut dapat dipahami melalui konsep ….",
            "6.Keterkaitan antara faktor yang satu dengan faktor yang lainnya dan terjadi di permukaan bumi tersebar tidak merata, dapat dipelajari dengan menggunakan prinsip ....",
            "7.Indonesia yang terletak di perbatasan lempeng Eurasia, Indo Australia, dan lempeng Pasifik menyebabkan Indonesia menjadi daerah …",
            "8.Faktor yang tidak berpengaruh terhadap pelapukan atau proses penghancuran massa batuan adalah .....",
            "9.Lapisan atmosfer tempat terjadi peristiwa pelangi, halilintar, dan pembentukan awan dinamakan .....",
            "10.Daerah pantai sering dilanda banjir pasang (rob). Kondisi ini dimanfaatkan penduduk untuk usaha pertambakan.\n" +
                    "Pendekatan geografi untuk menganalisis hal tersebut adalah pendekatan ….\n"
    };
    String[] pilihan_jawaban = new String []{
            "Analisis networking","Analisis garis dan bidang","Analisis buffering","Analisis overlayAnalisis overlay",
            "Inventarisasi tanaman perkebunan dan pertanian","Inventarisasi hutan untuk perencanaan reboisasi","Inventarisasi jenis hama tanaman","Informasi lingkungan tempat pembuangan ",
            "Relief wilayah bervariasi","Wilayah terletak di pingggir pantai","Lereng wilayah curam","Kondisi tanah sangat subur",
            "19,7 km dari kota A","20,8 km dari kota B","21,8 km dari kota A","22,7 km dari kota A",
            "pola","nilai","letak","morfologi",
            "distribusi dan interaksi","interelasi dan distribusi","korologi dan keruangan","deskripsi dan interelasi",
            "dilewati badai tropis","rawan gempa bumi","pergerakan El Nino dan La Nina","punggungan samudra",
            "struktur batuan","iklim","topografi","gempa bumi",
            "stratosfer","ionosfer","termosfer","troposfer",
            "spasial","ekologi","keruangan","kewilayahan",
    };
    String[] jawaban_benar = new String[]{
            "Analisis overlay",
            "Inventarisasi tanaman perkebunan dan pertanian",
            "Kondisi tanah sangat subur",
            "20,8 km dari kota B",
            "letak",
            "interelasi dan distribusi",
            "rawan gempa bumi",
            "gempa bumi",
            "troposfer",
            "kewilayahan"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_geo);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisGeo3.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
