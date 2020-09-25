package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Sos extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Tindakan sosial masyarakat idealnya diarahkan untuk mewujudkan...",
            "2.Perhatikan contoh berikut!\n" +
                    "1. Pertandingan sepakbola antarklub di Jakarta.\n" +
                    "2. Pabrik itu dirikan secara patungan.\n" +
                    "3. Di antara pihak-pihak yang bertikai timbul rasa benci.\n" +
                    "4. Terjadi perang urat saraf antara A dan B.\n" +
                    "Dari contoh di atas yang termasuk kontravensi adalah:\n",
            "3.Nilai dalam interaksi sosial berperan sebagai...",
            "4.Fungsi nilai sosial dalam kehidupan masyarakat adalah...",
            "5.Norma dijadikan pedoman hidup dalam memenuhi kebutuhan sosial sebab...",
            "6.Suami istri berhak berciuman. Akan tetapi, di Indonesia pasangan suami istri ini tidak melakukannya di depan umum karena bertentang dengan dengan norma...",
            "7.Perhatikan hal-hal berikut!\n" +
                    "1) Menamkan nilai dan norma yang dianut masyarakat\n" +
                    "2) Membentuk kemampuan beradaptasi dengan lingkungan yang lebih luas\n" +
                    "3) Sarana pemenuhan kebutuhan hidup individu dan kelompok\n" +
                    "4) Sebagai dasar pembentukan kepribadian seseorang\n" +
                    "Dari pernyataan di atas yang termasuk peran sosialisasi primer dan sosialisasi sekunder adalah...\n",
            "8.Salah satu faktor yang memengaruhi kepribadian seseorang yang berkaitan dengan",
            "9.Salah satu contoh fungsi media massa dalam sosialisasi sekunder adalah...",
            "10.Perhatikan pernyataan di bawah ini!\n" +
                    "1. Kerusuhan dan kebakaran di bulan Mei 1998\n" +
                    "2. Penyalahgunaan narkotika dan obat terlarang\n" +
                    "3. Pemerkosaan terhadap pembantu rumah tangga\n" +
                    "4. Terganggunya keamanan di daerah perbatasan\n" +
                    "Dari perilaku-perilaku di atas yang termasuk penyimpangan sekunder adalah nomor...\n"
    };

    String[] pilihan_jawaban = new String []{
            "kaidah","interaksi","pranata","norma",
            "1 dan 2","1 dan 3","1 dan 4","3 dan 4",
            "Pengendali tingkah laku","pedoman pola pikir","Pendorong tindakan sosial","petunjuk kehidupan sosial",
            "Memberi contoh tentang perilaku yang baik","Sebagai pengawas perilaku manusia","Membedakan hal-hal yang disukai dan tidak disukai","Gambaran tentang anjuran dan larangan",
            "Mengembangkan nilai persatuan dan patriotisme","Mengungkapkan rasa estetika","Mengatur berbagai aktifitas","Mengembangkan prinsip benar salah",
            "Agama","Hukum","Kesusilaan","Kesopanan",
            "1 dan 2","1 dan 3","1 dan 4","2 dan 3",
            "Warisan biologis","Lingkungan geografis","Lingkungan budaya","Lingkungan sosial",
            "Memicu masyarakat menjadi konsumtif","Menanamkan nilai-nilai fundamental","Membudayakan masyarakat secara formal","Menanamkan rasa tenteram dan damai",
            "1 dan 2","1 dan 3","1 dan 4","3 dan 4"
    };

    String[] jawaban_benar = new String[]{
            "interaksi",
            "3 dan 4",
            "Pengendali tingkah laku",
            "Sebagai pengawas perilaku manusia",
            "Mengembangkan prinsip benar salah",
            "Kesusilaan",
            "1 dan 2",
            "Lingkungan geografis",
            "Membudayakan masyarakat secara formal",
            "3 dan 4"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_sos);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisSos1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
