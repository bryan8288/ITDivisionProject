package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Sos extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Perhatikan pernyataan berikut!\n" +
                    "1. Dikenakan hukuman kurungan\n" +
                    "2. Dikucilkan dari masyarakatnya\n" +
                    "3. Gosip lisan secara luas\n" +
                    "4. Diharuskan membayar denda berupa uang atau barang\n" +
                    "Pernyataan tersebut yang termasuk jenis pengendalian sosial yang berlaku pada masyarakat tradisional adalah nomor...\n",
            "2.Hukuman pidana bagi pelaku tindak pembunuhan termasuk contoh pengendalian sosial dengan cara...",
            "3.Orang-orang yang menduduki lapisan sosial yang berdasarkan ukuran kekuasaan, misalnya...",
            "4.Pelapisan sosial berdasarkan sistem kasta bersifat tertutup sebab...",
            "5.Penggolongan masyarakat ke dalam kelompok tertentu seperti pedagang, pegawai, nelayan, pengusaha, pengrajin, dan pejabat pemerintah merupakan diferensiasi sosial berdasarkan....",
            "6.Pernyataan di bawah ini:\n" +
                    "1. Terjadinya pertentangan antara kubu pendukung Persib dengan pendukung Persija\n" +
                    "2. Dilakukan musyarawah untuk menyelesaikan pertikaian\n" +
                    "3. Diselesaikannya pertentangan antara keluarga dan Amir dan Bima di pengadilan\n" +
                    "4. Saat demonstrasi mahasiswa berlangsung di sekitar Semanggi Jakarta, terjadi pula penjarahan besar-besaran yang dilakukan oleh orang-orang tidak bertanggungjawab\n" +
                    "Perbedaan antara konflik dan kekerasan dapat dilihat pada pernyataan...\n",
            "7.Ketika para siswa hendak mengadakan widyawisata, terjadilah perbedaan pendapat dalam menentukan obyek. Untuk mencapai mufakat diadakan voting. Contoh penyelesaian konflik tersebut termasuk bentuk akomodasi...",
            "8.Pada prinsipnya status seseorang dapat diperoleh dengan cara-cara bersifat...",
            "9.Perhatikan beberapa saluran mobilitas sosial vertikal berikut ini...\n" +
                    "1) Alih profesi dari pegawai menjadi pedagang\n" +
                    "2) Rotasi kepala sekolah dari SMAN 5 ke SMAN 1\n" +
                    "3) Seluruh siswa kelas tiga sosial SMA Belawan diterima di beberapa perguruan tinggi negeri dan swasta.\n" +
                    "4) Pak Hadi seorang guru sosiologi dari SMA Bangka pindah menjadi guru sosiologi di Belitung\n" +
                    "5) Seorang menteri di salah satu negara menjadi anggota salah satu partai\n" +
                    "Di antara pernyataan di atas yang tergolong ke dalam mobilitas vertikal adalah ...\n",
            "10.Contoh mobilitas vertikal ke atas di bidang pendidikan adalah ..."
    };

    String[] pilihan_jawaban = new String []{
            "1 dan 2","1 dan 3","2 dan 3","2 dan 4",
            "Antisipatif","Regulatif","Persuasif","Preventif",
            "Orang yang berjasa dalam suatu negara dalam hal agama","Semua guru yang bekerja dengan tekun","Ilmuwan dan cendekiawan","Para pejabat pemerintah",
            "Sistem kasta hanya dikenal di negara India","Kasta diperoleh melalui keturunan dan berlaku seumur hidup","Masyarakat Bali sebagian besar memeluk agama Hindu","Sejak India merdeka pelaksanaan sistem kasta cenderung lunak",
            "Peranan","Suku","Agama","Profesi",
            "2 dan 4","1 dan 4","1 dan 3","1 dan 2",
            "Subjugation","Stalemate","Majority rule","Elimination",
            "Subjektif, objektif, dan Otomatis","Otomatis, ada usaha, dan subjektif","Konflik, Simbol, dan Assigned","Ascribed, Achieved, dan Assigned",
            "1 dan 2","1 dan 3","2 dan 3","3 dan 4",
            "Rianto mendapat promosi jabatan sebagai kepala seksi kantor","Di antara teman sekelasnya hanya Abdi yang lulus SNMPTN","Dia mendapat keuntungan dari menjual buku pelajaran","Tino dapat membeli sepeda yang baru setelah sepedanya rusak"
    };

    String[] jawaban_benar = new String[]{
            "2 dan 3",
            "Regulatif",
            "Para pejabat pemerintah",
            "Kasta diperoleh melalui keturunan dan berlaku seumur hidup",
            "Profesi",
            "1 dan 4",
            "Majority rule",
            "Ascribed, Achieved, dan Assigned",
            "1 dan 3",
            "Di antara teman sekelasnya hanya Abdi yang lulus SNMPTN"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_sos);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisSos2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
