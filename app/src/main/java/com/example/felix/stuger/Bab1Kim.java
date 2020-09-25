package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Kim extends AppCompatActivity {



        TextView pertanyaan;
        RadioGroup rg;
        RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
        int nomor = 0;
        public static int hasil , benar , salah;

        String[] pertanyaan_kuis = new String[]{
                "1.Di antara konfigurasi electron berikut yang merupakan konfigurasi electron unsure X (nomor atom 24) adalah…. ",
                "2.Ion X- mempunyai konfigurasi  electron 1s2 2s22p6 3s2 3p6  maka dalam system periodic unsure X terletak pada…. ",
                "3. Unsur A (nomor atom 15) bersenyawa dengan unsure B (nomor atom 17) maka dapat membentuk senyawa AB3, maka banyaknya pasangan electron terikat dan bebas  disekitar atom pusat berturut turut adalah… ",
                "4.Jika unsur X dengan nomor atom 20, berikatan dengan unsure Y dengan nomor atom 17, maka jenis ikatan dan rumus molekul yang  terbentuk adalah …. ",
                "5.Persamaan reaksi berikut: a CaCO3 + b HCl ---> c  CaCl2 + d H2O akan setara jika harga abc dan d berturut turut adalah… ",
                "6.Senyawa besi (II) sulfide direaksikan dengan larutan aam klorida menurut persamaan reaksi: FeS  +  2HCl   ---->  FeCl2 + H2S Jika reaksi tersebut menghasilkan 5,6 L gas H2S (STP) maka massa besi (II) sulfide (Mr=88) yang bereaksi adalah… ",
                "7. Sebanyak 10 Liter gas butane (C4H10) dibakar sempurna menurut reaksi C4H10   +  O2  ---->   CO2  +  H2O belum setara Jika diukur pada suhu dan tekanan yang sama, volume CO2 dan H2O yang dihasilkan adalah… ",
                "8. Dari reaksi H3O+ + HSO3-  ---->  H2SO3  +  H2O Yang merupkan pasangan asam basa konjugasi adalah..",
                "9.Sebanyak 300 mL CH3COOH 0,1 M (Ka= 2 . 10-5) dicampur dengan 200 mL KOH 0,1 M, maka campuran yang diperoleh memiliki pH sebesar … ",
                "10.Diantara campuran larutan berikut yang menghasilkan garam terhidrolisis sebagian dan bersifat asam adalah… "
        };
        String[] pilihan_jawaban = new String []{
                "1s2 2s22p6 3s2 3p6 3d4 4s","1s2 2s22p6 3s2 3p6 3d6 4s2","1s2 2s22p6 3s2 3p6 3d2 4s14p3 ","1s2 2s22p6 3s2 3p6 3d5 4s1",
                "Golongan VIIIA Periode 3","Golongan VIIA periode 3","Golongan IA periode 4","Golongan VIA periode 3",
                "1 dan 3","2 dan 2","3 dan 1","4 dan 1",
                "ion dengan rumus XY","ion dengan rumus XY2","Kovalen  dengan rumus X2Y3","Ion dengan rumus X2Y",
                "1,1,2,1","2,1,1,1 ","2,2,1,1","1,2,1,1",
                "22 gram","29 gram","35 gram","45 gram",
                "4L dan 5L","20L dan 25L","50L dan 40L","40L dan 50 L",
                "H3O+ dan H2O","H2O  dan H3O+","H2SO3 dan H3O "," SO3- dan H2O",
                "4","6","10","5",
                "50 mL 0,5M HCl +  50 mL 0,5M KOH","50 mL 0,5M HCl + 100ml 0,5M NH3","50 mL 0,5M HCN + 50 mL 0,5M KOH","50mL 0,5M HCl +  50 mL 0,5 M NH3",
        };
        String[] jawaban_benar = new String[]{
                "1s2 2s22p6 3s2 3p6 3d5 4s1",
                "Golongan VIIA periode 3",
                "3 dan 1",
                "ion dengan rumus XY2",
                "1,2,1,1",
                "22 gram",
                "40L dan 50 L",
                "H3O+ dan H2O",
                "5",
                "50mL 0,5M HCl +  50 mL 0,5 M NH3"
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_kim);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisKim1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
