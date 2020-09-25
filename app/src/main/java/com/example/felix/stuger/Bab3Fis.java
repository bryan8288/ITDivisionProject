package com.example.felix.stuger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Bab3Fis extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB , PilihanC , PilihanD;
    int nomor = 0;
    public static int hasil , benar , salah;

    String[] pertanyaan_kuis = new String[]{
            "1.Sebuah partikel melakukan getaran harmonis dengan persamaan y = 30 sin 100πt. Nilai amplitudonya adalah ….",
            "2.Prinsip hukum pascal dapat diaplikasikan dalam peralatan-peralatan di bawah ini kecuali.....",
            "3.Diketahui Muatan listrik 50 C pada jarak 3 cm dari muatan 300 C. Jika k = 9 x 109 Nm2/C2, besarnya gaya couloumbnya adalah .…",
            "4.Ruang di sekitar benda bermuatan listrik yang masih dipengaruhi oleh gaya listrik disebut ...",
            "5.Dua keping sejajar diberi muatan listrik yang sama besarnya dan berlawanan tanda. Kuat medan listrik di antara dua keping itu akan .....",
            "6.Besar potensial di titk P yang berjarak 15 mm dari muatan 2 μc adalah ...",
            "7.Kapasitas suatu kapasitor keping sejajar yang mempunyai luas 50 cm2 dan jarak antar 2 keping kapasitor 2 cm adalah …..",
            "8.Pada kawat arus mengalir arus 20 ampere selama 20 sekon. Muatan listrik yang mengalir dalam kawat tersebut adalah …..",
            "9.Sebuah peralatan listrik yang dipakai pada tegangan 220 volt memiliki hambatan 22 ohm. Besarnya kuat arus listrik yang dipakai pada peralatan listrik tersebut adalah …",
            "10.Lima buah hambatan masing-masing 20 ohm dipasang paralel, maka hambatan penggantinya adalah......",
    };
    String[] pilihan_jawaban = new String []{
            "10 cm","20 cm","30 cm","40 cm",
            "Dongkrak hidrolik","Pompa hidrolik","Gaya angkat pesawat","Rem piringan hidrolik",
            "15 x 1016 N","14 x 1016 N","13 x 1016 N","12 x 1016 N",
            "Garis-garis medan listrik","Medan listrik","Kuat medan listrik","Gaya coloumb",
            "Berbanding lurus dengan rapat muatanya","Berbanding terbalik dengan rapat muatanya","Berbanding terbalik dengan jarak kuadrat antara kedua keping","Arahnya menuju ke keping yang bermuatan positif",
            "1,2 x 106 V","5,2 x 106 V","3,3 x 106 V","2,2 x 106 V",
            "2,3 x 10-12 F","2,2 x 10-12 F","2,5 x 10-12 F","2,6 x 10-12 F",
            "600 C","500 C","400 C","700 C",
            "10 A","9 A","8 A","6 A",
            "3 ohm","4 ohm","5 ohm","6 ohm",
    };
    String[] jawaban_benar = new String[]{
            "30 cm",
            "Gaya angkat pesawat",
            "15 x 1016 N",
            "Medan listrik",
            "Berbanding lurus dengan rapat muatanya",
            "1,2 x 106 V",
            "2,2 x 10-12 F",
            "400 C",
            "10 A",
            "4 ohm",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3_fis);
    }
}
