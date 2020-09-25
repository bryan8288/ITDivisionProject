package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Eko extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Perusahaan 'uZen\" mengekspor getah mentah ke negara tetangga, permintaan getah mentah dari tahun ke tahun *inirrgtutiehingga perusahaan berusaha memenuhi perrnintaan dari negara tetangga. Peran dari perusah a&fi \"Zerf' adalah -\".. ",
            "2.Penerimaan devisa sebagai sumber dana pembangunan pada negara berkembang digunakan untuk melindungi sektor induski dan menutup neraca pernbayaran yang defisit. Untuk rnenutup kekurangan devisa, maka kebijakan yang diarnbil pernerintah adalah.... ",
            "3.Kelangkaan merupakan inti masalah ekonomi yang salah satunya memaksa manusia untuk melakukan pilihan dalam hidupnya baik secara individual maupun kolektif yang disebabkan oleh ….",
            "4.Dalam rangka mengatasi inflasi pemerintah dan Bank Indonesia bekerja sama melakukan kebijakan Disconto Policy yaitu ….",
            "5.Dalam pasar modal kepemilikan saham harus memiliki syarat yang ditentukan oleh lembaga penunjang pasar modal yang menjamin pembayaran kembali jumlah pokok dan bunga emisi obligasi atau surat berharga kredit dalam hal emiten ingkar janji. Lembaga tersebut adalah ….",
            "6.Diketahui GNP suatu negara Rp20.800.000.000; penyusutan Rp700.000.000; pajak tidak langsung Rp50.000.000; dan pajak langsung Rp60.000.000. Besarnya NNI yaitu ….",
            "7.Transaksi pembelian perlengkapan secara kredit, akan berpengaruh terhadap persamaan dasar akuntansi ….",
            "8.Penggolongan pasar dilihat dari strukturnya adalah….",
            "9.Pemerintah menguasai alat produksi penting bagi Negara dan menguasai hajat hidup orang banyak. Pernyataan ini merupakan salah satu ciri-ciri sistem ekonomi….",
            "10.Cangkul lebih berguna ditangan petani jika dibandingkan dimiliki seorang pelajar, begitu pula buku dan pulpen lebih berguna di tangan pelajar jika dibandingkan di tangan petani. Hal ini merupakan contoh…."
    };
    String[] pilihan_jawaban = new String []{
            "menciPtakan Produk unggulan","sebagai sumber pendapatan negara","mengurangi jumlah Pengangguran","menciptakan lapangan pekerjaan",
            "penerapan tarif ekspor yang tinggi","larangan ekspor untuk semua komoditas","larangan impor untuk bahan kebutuhan pokok","ekspor barang dengan bayaran valuta asing",
            "keterbatasan jumlah  alat pemuas kebutuhan yang tersedia di alam","peningkatan investasi sebagai akibat dari modernisasi global","terjadinya bencana alam","perkembangan potensi sumber daya manusia",
            "menaikkan tingkat suku bunga sehingga masyarakat lebih suka berinvestasi","menaikkan tingkat suku bunga sehingga masyarakat rajin menabung","menjual surat berharga sehingga uang yang beredar di masyarakat berkurang","membeli surat berharga sehingga uang yang beredar di masyarakat bertambah",
            "perusahaan penilai","penanggung (quarantor)","trust agent","konsultan hukum",
            "Rp110.000.000","Rp850.000.000","Rp20.050.000.000","Rp20.740.000.000",
            "akun harta bertambah, utang berkurang","akun utang bertambah, modal berkurang","akun harta bertambah, modal bertambah","akun harta bertambah, utang bertambah",
            "pasar abstrak dan pasar konkret","pasar sempurna dan tidak sempurna","pasar abstrak dan pasar sempurna","pasar konkret dan pasar tidak sempurna",
            "alternatif","terpusat","pasar","campuran",
            "from utility","time utility","ownership utility","element utility",
    };
    String[] jawaban_benar = new String[]{
            "menciptakan lapangan pekerjaan",
            "larangan impor untuk bahan kebutuhan pokok",
            "keterbatasan jumlah  alat pemuas kebutuhan yang tersedia di alam",
            "menaikkan tingkat suku bunga sehingga masyarakat rajin menabung",
            "penanggung (quarantor)",
            "Rp20.050.000.000",
            "akun harta bertambah, utang bertambah",
            "pasar sempurna dan tidak sempurna",
            "campuran",
            "ownership utility"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_eko);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisEko2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
