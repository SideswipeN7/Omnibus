package com.example.asuper.omnibus;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.asuper.omnibus.Klasy.Omnibus;
import com.example.asuper.omnibus.Klasy.Uzytkownik;
import com.example.asuper.omnibus.Klasy.Zestaw;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Zestaw> mZestaw;
    private int mUserId;
    private Omnibus mDb;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainActivity.GetZestawTask().execute();
        //SystemClock.sleep(200);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        mUserId = intent.getIntExtra("UserId", 0);
        Toast.makeText(getApplicationContext(), "ID UŻYTKOWNIKA: " + mUserId, Toast.LENGTH_SHORT).show();

    }

    public void onClickTop10(View view) {
        Intent intent = new Intent(MainActivity.this, Top10Activity.class);
        startActivity(intent);
    }

    public void onClickMyScores(View view) {
        Intent intent = new Intent(MainActivity.this, MyScoresActivity.class);
        intent.putExtra("UserId", mUserId);
        startActivity(intent);
    }

    public void onClickAbout(View view) {
        Intent intent=new Intent(MainActivity.this,AboutActivity.class);
        startActivity(intent);
    }

        public void onClickLogOff(View view) {
        finish();
    }

    public void onClickStartGame(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("UserId", mUserId);
//if(mDb.getZestaw()!=null) {
//    intent.putExtra("DB", mDb);
//}
        startActivity(intent);
    }


    class GetZestawTask extends AsyncTask<Void, Void, Void> {


        protected Void doInBackground(Void... u) {
            mDb = Omnibus.getSingelton();
            mZestaw = mDb.getZestaw();
            return null;
        }

        protected void onPostExecute(Void v) {
            Toast.makeText(getApplicationContext(), "Pobrano zestawy", Toast.LENGTH_SHORT).show();

        }
    }


}
