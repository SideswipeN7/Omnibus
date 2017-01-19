package com.example.asuper.omnibus;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asuper.omnibus.Klasy.Omnibus;

public class Top10Activity extends AppCompatActivity {
    Omnibus mDb;
    TextView[] tvList;// g1, g2, g3, g4, g5, g6, g7, g8, g9, g10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10);


        mDb = Omnibus.getSingelton();
        tvList = new TextView[]{
                (TextView) findViewById(R.id.tvG1),
                (TextView) findViewById(R.id.tvG2),
                (TextView) findViewById(R.id.tvG3),
                (TextView) findViewById(R.id.tvG4),
                (TextView) findViewById(R.id.tvG5),
                (TextView) findViewById(R.id.tvG6),
                (TextView) findViewById(R.id.tvG7),
                (TextView) findViewById(R.id.tvG8),
                (TextView) findViewById(R.id.tvG9),
                (TextView) findViewById(R.id.tvG10)
        };

        setData();

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();
    }

    public void setData() {
        if(mDb.check10Exists()){
        for (int i = 0; i < 10; i++) {
            tvList[i].setText(mDb.get1of10(i));
        }}
        else{
            new Top10Activity.GetTop10Task().execute();
        }

    }

    public void onClickGoBack(View view) {
        finish();
    }


    class GetTop10Task extends AsyncTask<Void, Void, Void> {


        protected Void doInBackground(Void... u) {
            mDb = Omnibus.getSingelton();
            mDb.getTop10();
            return null;
        }

        protected void onPostExecute(Void v) {
            Toast.makeText(getApplicationContext(), "Pobrano TOP10 Wyniki", Toast.LENGTH_SHORT).show();
            setData();
        }
    }

}
