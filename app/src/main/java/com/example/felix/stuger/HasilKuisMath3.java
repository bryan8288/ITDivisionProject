package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilKuisMath3 extends AppCompatActivity {
private Button Homebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis_math3);
        Homebtn = findViewById(R.id.ButtonHome);
        Homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardActivity();
            }
        });
        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);
        TextView total = (TextView)findViewById(R.id.total_score);

        hasil.setText("Jawaban Benar :"+Bab3Math.benar+"\nJawaban Salah :"+Bab3Math.salah);
        nilai.setText(""+Bab3Math.hasil);

        int total1;
        total1 = Bab1Bio.hasil+Bab2Bio.hasil+Bab3Bio.hasil+Bab1Eko.hasil+Bab2Eko.hasil+Bab3Eko.hasil+Bab1Fis.hasil+Bab2Fis.hasil+Bab3Fis.hasil+Bab1Geo.hasil+Bab2Geo.hasil+Bab3Geo.hasil+Bab1Kim.hasil+Bab2Kim.hasil+Bab3Kim.hasil+Bab1Math.hasil+Bab2Math.hasil+Bab3Math.hasil+Bab1Ppkn.hasil+Bab2Ppkn.hasil+Bab3Ppkn.hasil+Bab1Sos.hasil+Bab2Sos.hasil+Bab3Sos.hasil;
        total.setText("Total Score Anda : "+String.valueOf(total1));
    }

    private void openDashboardActivity() {
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}
