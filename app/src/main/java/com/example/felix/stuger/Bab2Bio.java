package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab2Bio extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Virus tidak dapat masuk dalam kelompok makhluk hidup karena ....",
            "2.Virus tersusun atas selubung protein yang disebut ....",
            "3.Virus yang menginfeksi bakteri disebut ....",
            "4.Tahap-tahap daur litik yang benar adalah ....",
            "5.Lactobacillus bulgaricus adalah bakteri yang digunakan untuk membuat yoghurt dari bahan baku susu. Bakteri tersebut memiliki sifat…",
            "6.Bagian dari Anabaena yang berperan untuk mengikat nitrogen dari udara adalah…",
            "7.Archaebacteria berbeda dengan Eubacteria, karena Archaebacteria…",
            "8.Archaebacteria yang hidup di rawa dan menghasilkan gas metana adalah jenis bakteri…",
            "9.Jika bakteri diberi pewarna gram menunjukkan warna ungu maka bakteri tersebut adalah...",
            "10.Kelompok Protista anggotanya memiliki nukleus yang dilindungi oleh selaput inti. Oleh karena iu bersifat…",
    };
    String[] pilihan_jawaban = new String []{
            "virus dapat berkembang biak","virus dapat melakukan pembuahan","virus dapat bergerak","virus dapat dikristalkan",
            "kapsid","virion","vaksin","horpes",
            "bakteriofag","profag","mikrobakteri","mikroprofag",
            "adsorpsi – injeksi – litik – perakitan – sintesis","adsorpsi – perakitan – sintesis – litik – injeksi","adsorpsi – injeksi – sintesis – perakitan – litik","adsorpsi – injeksi – sintesis – litik – perakitan",
            "Aerob dan parasit","Aerob dan saprofit","Anaerob dan parasit","Anaerob dan saprofit",
            "Akinet","Heterosista","Hormogonium","Baeosit",
            "Prokariotik","Eukariotik","Memiliki peptidoglikan","Tidak memiliki peptidoglikan",
            "Termoasidofil","Metanogenik","Anaerob","Halofil",
            "Bakteri gram positip karena peptidoglikannya tipis","Bakteri gram positip karena peptidoglikannya tebal","Bakteri gram positip karena tidak memiliki peptidoglikan","Bakteri gram negatip karena peptidoglikannya tipis",
            "Eukarioik","Prokariotik","Mirip dengan jamur","Mirip dengan tumbuhan",
    };
    String[] jawaban_benar = new String[]{
            "virus dapat dikristalkan",
            "kapsid",
            "bakteriofag",
            "adsorpsi – injeksi – sintesis – perakitan – litik",
            "Anaerob dan saprofit",
            "Heterosista",
            "Tidak memiliki peptidoglikan",
            "Metanogenik",
            "Bakteri gram positip karena peptidoglikannya tebal",
            "Eukarioik",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2_bio);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisBio2.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
