package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab3Eko extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Tingkat produksi yang bahannya telah mengalami proses produksi pada tingkat pertama disebut….",
            "2.Tugas pokok sektor perusahaan sebagai pelaku kegiatan ekonomi adalah….",
            "3.Berikut ini yang merupakan contoh perilaku konsumen rasional adalah….",
            "4.Pada saat harga barang Rp100.00, barang yang diminta konsumen sebanyak 400 unit. Apabila harga naik harga naik Rp100,00 per unit barang yang diminta turun 150 unit, berdasarkan data di atas fungsi permintaannya adalah….",
            "5.Persamaan bursa dan pasar adalah….",
            "6.Sesuatu hal yang harus kita penuhi dan jika tidak terpenuhi aktivitaskita akan terganggu, bahkan mungkin kita tidakhidup. Hal tersebut merupakan pengertian....",
            "7.Berikut ini adalah kebijakan pemerintah dalam mengatasi kemiskinan adalah….",
            "8.Angka indeks yang menunjukan perubahan-perubahan yang terjadi pada jumlah komoditas yang dihasilkan atau jumlah komoditas yang dikonsumsi dariwaktu kewaktu adalah….",
            "9.Laju inflasi 30%-100% disebut…",
            "10.Suatu fungsi yang menunjukan hubungan antara pengeluarankonsumsi dengan tingkat pendapatan disebut…."
    };
    String[] pilihan_jawaban = new String []{
            "tingkat produksi primer","tingkat produksi tersier","tingkat produksi sekunder","tingkat produksi konsumsi",
            "menguasai jalur pemasaran","mengelola perusahaan secara efisien","menghasilkan barang dan jasa untuk dijual","menyediakan imbalan upah bagi para pekerja",
            "Andre membeli barang ingin dipuji","Sony membeli barang karena kredit","Aan membeli barang agar menambah prestise","Mila membeli barang karena sesuai kebutuhan",
            "Q=-2 -3000","Q=600-0,2 P","P = -2P/3Q + 1000","P = -2P/3Q + 3000",
            "pembelinya terbatas hanya untuk anggota","sarana yang mempertemukan penjual dan pembeli","penjual dan pembelinya bebas","setiap orang bebas untuk melakukan tranksaksi",
            "keinginan","kebutuhan","kemakmuran","kesejahteraan",
            "program IDT","program BLT","pembangunan didaerah terpencil","program KUT",
            "angka indeks dasar","angka indeks nilai","angka indeks kuantitas","angka indeks harga",
            "inflasi ringan","inflasi sedang","hyper inflasi","inflasi berat",
            "fungsi tabungan","fungsi investasi","fungsi konsumsi","inflasi",
    };
    String[] jawaban_benar = new String[]{
            "tingkat produksi sekunder",
            "menghasilkan barang dan jasa untuk dijual",
            "Mila membeli barang karena sesuai kebutuhan",
            "Q=600-0,2 P",
            "sarana yang mempertemukan penjual dan pembeli",
            "kebutuhan",
            "pembangunan didaerah terpencil",
            "angka indeks kuantitas",
            "inflasi berat",
            "fungsi konsumsi"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_eko);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisEko3.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
