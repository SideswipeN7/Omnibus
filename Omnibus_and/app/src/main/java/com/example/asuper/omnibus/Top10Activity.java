package com.example.asuper.omnibus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Top10Activity extends AppCompatActivity {

    TextView g1, g2, g3, g4, g5, g6, g7, g8, g9, g10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();

        g1 = (TextView) findViewById(R.id.tvG1);
        g2 = (TextView) findViewById(R.id.tvG2);
        g3 = (TextView) findViewById(R.id.tvG3);
        g4 = (TextView) findViewById(R.id.tvG4);
        g5 = (TextView) findViewById(R.id.tvG5);
        g6 = (TextView) findViewById(R.id.tvG6);
        g7 = (TextView) findViewById(R.id.tvG7);
        g8 = (TextView) findViewById(R.id.tvG8);
        g9 = (TextView) findViewById(R.id.tvG9);
        g10 = (TextView) findViewById(R.id.tvG10);


    }

    public void onClickGoBack(View view) {
        finish();
    }
}
