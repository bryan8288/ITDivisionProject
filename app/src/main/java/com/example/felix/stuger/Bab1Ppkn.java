package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Bab1Ppkn extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Secara harfiah ,ideologi berarti ilmu tentang.....",
            "2.Yang mengemukakan bahwa ideologi sebagai suatu sistem pemikiran dapat dibedakan menjadi ideologi tertutup dan ideologi terbuka adalah......",
            "3.Suatu kumpulan gagasan,ide – ide dasar serta kepercayaan yang bersifat sistematis yang memberikan arah dan tujuan yang hendak dicapai oleh suatu bangsa dan negara adalah pengertian....",
            "4.Berikut ini yang merupakan dimensi ideologi adalah....",
            "5.Hasil kerja panitia sembilan yang memuat rumusan dasar negara Indonesia merdeka adalah....",
            "6.Berikut ini yang bukan tokoh – tokoh nasional yang mengusulkan dasar negara bagi Indonesia merdeka adalah....",
            "7.Menurut risalah sidang BPUPKI, tiga orang yang mengemukakan gagasan tentang Pancasila dalam sidang BPUPKI adalah....",
            "8.Rumusan Pancasila menurut Pidato Soekarno 1 Juni 1945 adalah.....",
            "9.Nilai nilai Pancasila sebagai pandangan hidup bangsa Indonesia bersumber dari......",
            "10.Sifat yang mencerminkan kepribadian bangsa Indonesia adalah......"
    };
    String[] pilihan_jawaban = new String []{
            "Pengertian dasar atau ide","Teori ekonomi dan politik yang dipegang oleh seseorang atau sekelompok orang","Nilai-nilai dan cita-cita tertentu","Gagasan,konsep,pengertian dasar dan cita-cita",
            "A.S Hornby","Montesquieu","Alfian","Destutt de Tracy",
            "ideologi","Tujuan Negara","Falsafah Negara","Ideologi Pancasila",
            "Ketuhanan, Idealisme dan Realisme","Idealisme, Realisme, dan Fleksibilitas","Realitas, Ketuhanan dan Idealisme","Kenyataan, Keterbukaan dan Idealis",
            "Rancangan hukum dasar","UUD","Dasar Negara","Piagam Jakarta",
            "Moh.Yamin","Dr. KRT. Radjiman Wedyodiningrat","Prof. Mr. Soepomo","Ir. Soekarno",
            "Mohammad Yamin, Soepomo, dan Soekarno","Mohammad Yamin, H.Agus Salim, dan Soekarno","Mohammad Yamin, Soekiman, dan Soekarno","Mohammad Yamin, Mohammad Hatta, dan Soekarno",
            "Nasionalisme atau kebangsaan indonesia, internasionalisme atau perikemanusiaan,mufakat atau demokrasi,  kesejahteraan social,Ketuhanan yang berkebudayaan","Ketuhanan Yang Maha Esa, internasionalisme kebangsaan,mufakat atau demokrasi, kesejahteraan social","Ketuhanan Yang Maha Esa, mufakat atau demokrasi,internasionalisme,kebangsaan, ,kesejahteraan sosial","Mufakat atau demokrasi, kebangsaan,internasionalisme,kesejahteraan sosial, Ketuhanan YME",
            "Paham integralistik","Beberapa faham kenegaraan","Semangat nasionalisme di Asia","Akar budaya bangsa dan nilai nilai religius",
            "Demokrasi","Musyawarah Mufakat","Pancasila","Gotong royong",
    };
    String[] jawaban_benar = new String[]{
            "Pengertian dasar atau ide",
            "Alfian",
            "ideologi",
            "Idealisme, Realisme, dan Fleksibilitas",
            "Piagam Jakarta",
            "Dr. KRT. Radjiman Wedyodiningrat",
            "Mohammad Yamin, Soepomo, dan Soekarno",
            "Nasionalisme atau kebangsaan indonesia, internasionalisme atau perikemanusiaan,mufakat atau demokrasi,  kesejahteraan social,Ketuhanan yang berkebudayaan",
            "Akar budaya bangsa dan nilai nilai religius",
            "Gotong royong"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1_ppkn);
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
                Intent selesai = new Intent(getApplicationContext(), HasilKuisPpkn1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilihlah Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
