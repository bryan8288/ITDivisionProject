package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Eko extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Seorang pengusaha handycraft ingin mengembangkan produk, sehingga banyak permintaan di pasaran. Untuk memenuhi pemintaan tersebut pengusaha menambah mesin dan tenaga \\Marga dari lingkungan sekitar. Berdasmkan ilustrasi di atas, masalah pokak ekonomi dari pengusaha adalah .... ",
            "2.Andri siswa SMA mempunyai uang sebesar Rp500.000,00. Dia rnempunyai beberapa kebutuhan antara lain, beli seragam sekolah Rp30.000,00, beli buku pelajaran Rp200.000,00, beli sepatu futsal Rp300.000,00 dan beli tas sekolah Rp200.000,00 untuk mengganti tas lama yang masih bagus dan layak pakai. Untuk memenuhi kebutuhan tersebut cara mengatasinya adalah .-.' ",
            "3.Da1am sistem ekonomi perekonornian sepenuhnya dikuasai oleh negara, segala sesuatu yang berhubungan dengan perekonomian dirancang oleh pemerintah, sehingga kesej ahteraan terwuj ud. Peran masyarakat dalam sistem ini adalah .... ",
            "4.Jika pada tingkat harga Rpl0,00 jumlah barang yang diminta sebanyak 10 unit, sedangkan pada tingkat harga Rp2,00 jumlah barang yang diminta sebanyak 50 unit penawaran Qs : 5p + 10. Maka titik keseimbangan terletak pada .... ",
            "5.Memasuki buian Ramailhan, fenomena tahunan meningkatnya permintaan akan komoditas pangan karena jumlah uang yang beredar di masyarakat meningkat. Kondisi seperti ini al<an berujung pada kenaikan harga. Untuk melgatasi permasalahan di atas dengan menggunahan kebijakan ntoneter adaiah .... ",
            "6.Pada saat kemarau masyarakat kekurangan kebutuhan beras karena petani gagal panen sehingga harus mengimpor beras dari luar negeri. Maka kebijakan yang dilakukan oleh pemerintah adalah .... ",
            "7.Sebagian besar penduduk Indonesia masih berada dalam kemiskinan. Sebagian besar kekayaan banyak dirniliki kelompok berpenghasilan besar. Upaya pemerintah untuk mengatasi masalah tersebut adalah .. .. ",
            "8.Di Indonesia terdapat masalah yang belum terpecahkan, yang salah satunya teaaga kerja yang belum mendapatkan lapangan pekerjaan sehingga menimbulkan pengangguran. Dampak pengangguran terhadap pembangunan ekonomi adalah ....",
            "9.Ibu Yana seorang eksportir gannen memperoleh pesanan untuk menjuai barangnya ke negara Beianda senilai Euro 100.000,00. Dua hari kemudian ibu Yana membeii barangbarang kebutuhan perusahaan berupa bahan baku pembuatan garnen besefia asesorisnya senilai Euro 50.000,00. Jika kurs yang berlaku saat ini, krrrs jual Euro 1,00 : Rp16.000,00 dan kurs beli Euro 1,00 : Rp15.000,00. Jumlah uang yang diterima ibu Yana dalam n:piah adalah.... ",
            "10.pak Sulaiman pemilik perusahaan perkebunan kelapa sawit mencoba melakukan cara baru dalam mengeloia tahan perkebunaa agar keiapa sawit yang dihasilkan bisa berkembang lebih baik. Usaha Pak Sulaiman ini termasuk dalam unsur manajemen"
    };
    String[] pilihan_jawaban = new String []{
            "barang apa yang akan diproduksi","siapa yang akan memProduksi","bagaimana akan diproduksi barang","dimana barang diproduksi",
            "membeli sepatu futsal dan buku pelajaran","membuat skala prioritas kebutuhan","mencari alternatif kebutuhan iain","membeli semua kebutuhan dengan cara apapun",
            "pelaksana kebijakan pemerintah pusat","melakukan produksi dalam skala kecil","pemilik faktor produksi tanah","bebas memilih produksi yang diinginkan",
            "(5;7)","(5:25)","(25:5)","(35:5)",
            "membeli surat-surat berharga","menaikkan tingkat suku bunga","meningkatkan penerimaan pemerintah","mengurangi pengeluaran pemerintah",
            "mernberikan tarif pajak tinggi","memberikan subsidi bagi Petani","meningkatkan produktivitas","mengurangi anggaran negara",
            "menggalakkan program transmigrasi bagi masyarakat perkotaan"," pemerintah menggalakkan program KB bagi pasangan muda","menaikkan besar bantuan tunai (BLT) bagi masyarakat miskin","pemerintah memberikan bantuan krsdit modal kerja permanen",
            "pendapatan perkapita meningkat","kriminalitas meningkat","pendapatan masyarakat menurun","pendapatan nasional meningkat",
            "Rp650.000.000,00","Rp850.000.000,00","Rp800.000.000,00","Rp750.000.000,00",
            "man","money","material","method",
    };
    String[] jawaban_benar = new String[]{
            "bagaimana akan diproduksi barang",
            "membuat skala prioritas kebutuhan",
            "melakukan produksi dalam skala kecil",
            "(35:5)",
            "menaikkan tingkat suku bunga",
            "meningkatkan produktivitas",
            "pemerintah memberikan bantuan krsdit modal kerja permanen",
            "pendapatan masyarakat menurun",
            "Rp750.000.000,00",
            "method"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_eko);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisEko1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
