package com.example.asuper.omnibus;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asuper.omnibus.Klasy.Omnibus;
import com.example.asuper.omnibus.Klasy.Wynik;
import com.example.asuper.omnibus.Klasy.Zestaw;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    public ArrayList<Zestaw> mZestaw;
    private int mUserId;
    private int i = 0;
    private int max;
    private Button mPytanie, mOdp1, mOdp2, mOdp3, mOdp4;
    private boolean next = false;
    private int points = 0;
    private boolean exit = false;
    private Omnibus db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        mUserId = intent.getIntExtra("UserId", 0);

        new GameActivity.GetZestawTask().execute();


        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();


        mPytanie = (Button) findViewById(R.id.btPytanie);
        mOdp1 = (Button) findViewById(R.id.btOdp1);
        mOdp2 = (Button) findViewById(R.id.btOdp2);
        mOdp3 = (Button) findViewById(R.id.btOdp3);
        mOdp4 = (Button) findViewById(R.id.btOdp4);

        mPytanie.setBackgroundColor(Color.MAGENTA);

        mOdp1.setBackgroundColor(Color.argb(255, 63, 81, 181));
        mOdp2.setBackgroundColor(Color.argb(255, 63, 81, 181));
        mOdp3.setBackgroundColor(Color.argb(255, 63, 81, 181));
        mOdp4.setBackgroundColor(Color.argb(255, 63, 81, 181));

    }

    public void startGame() {
        mOdp1.setBackgroundColor(Color.argb(255, 63, 81, 181));
        mOdp2.setBackgroundColor(Color.argb(255, 63, 81, 181));
        mOdp3.setBackgroundColor(Color.argb(255, 63, 81, 181));
        mOdp4.setBackgroundColor(Color.argb(255, 63, 81, 181));

        mPytanie.setText(mZestaw.get(i).getPyt().getTekst());
        mPytanie.setTag(mZestaw.get(i).getPyt().getNrOdpPop());

        Collections.shuffle(mZestaw.get(i).getOdp());

        mOdp1.setText("A) " + mZestaw.get(i).getOdp().get(0).getTekst());
        mOdp1.setTag(mZestaw.get(i).getOdp().get(0).getNrOdpowiedzi());

        mOdp2.setText("B) " + mZestaw.get(i).getOdp().get(1).getTekst());
        mOdp2.setTag(mZestaw.get(i).getOdp().get(1).getNrOdpowiedzi());

        mOdp3.setText("C) " + mZestaw.get(i).getOdp().get(2).getTekst());
        mOdp3.setTag(mZestaw.get(i).getOdp().get(2).getNrOdpowiedzi());

        mOdp4.setText("D) " + mZestaw.get(i).getOdp().get(3).getTekst());
        mOdp4.setTag(mZestaw.get(i).getOdp().get(3).getNrOdpowiedzi());

    }

    public void checkAnswers(int x, int y) {
        if ((int) mPytanie.getTag() == x) {
            i++;
            points++;
            next = true;
            switch (y) {
                case 1:
                    mOdp1.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
                case 2:
                    mOdp2.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
                case 3:
                    mOdp3.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
                case 4:
                    mOdp4.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
            }
        } else {
            switch (y) {
                case 1:
                    mOdp1.setBackgroundColor(Color.argb(255, 234, 29, 18));
                    break;
                case 2:
                    mOdp2.setBackgroundColor(Color.argb(255, 234, 29, 18));
                    break;
                case 3:
                    mOdp3.setBackgroundColor(Color.argb(255, 234, 29, 18));
                    break;
                case 4:
                    mOdp4.setBackgroundColor(Color.argb(255, 234, 29, 18));
                    break;
            }

            int pop = 0;
            if ((int) mOdp1.getTag() == (int) mPytanie.getTag()) pop = 1;
            if ((int) mOdp2.getTag() == (int) mPytanie.getTag()) pop = 2;
            if ((int) mOdp3.getTag() == (int) mPytanie.getTag()) pop = 3;
            if ((int) mOdp4.getTag() == (int) mPytanie.getTag()) pop = 4;


            switch (pop) {
                case 1:
                    mOdp1.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
                case 2:
                    mOdp2.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
                case 3:
                    mOdp3.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
                case 4:
                    mOdp4.setBackgroundColor(Color.argb(255, 62, 241, 21));
                    break;
            }
            if (!exit)
                endGame();
        }
    }

    private void endGame() {
        Toast.makeText(getApplicationContext(), "Koniec gry zdobyłeś: " + points + " punktów", Toast.LENGTH_LONG).show();
        new GameActivity.SendDataTask().execute();
        exit = true;
    }


    public void onClickBtO(View view) {
        if (exit) {
            next = false;
            finish();
        }
        if (next) {
            if (i < max) {
                startGame();
                next = false;
            } else {
                endGame();
            }
        }

    }

    public void onClickBt1(View view) {
        if (next)
            Toast.makeText(getApplicationContext(), "Naciśnij pytanie by przejść dalej", Toast.LENGTH_SHORT).show();
        if (!next)
            checkAnswers((int) mOdp1.getTag(), 1);

    }

    public void onClickBt2(View view) {
        if (next)
            Toast.makeText(getApplicationContext(), "Naciśnij pytanie by przejść dalej", Toast.LENGTH_SHORT).show();
        if (!next)
            checkAnswers((int) mOdp2.getTag(), 2);

    }

    public void onClickBt3(View view) {
        if (next)
            Toast.makeText(getApplicationContext(), "Naciśnij pytanie by przejść dalej", Toast.LENGTH_SHORT).show();
        if (!next)
            checkAnswers((int) mOdp3.getTag(), 3);

    }

    public void onClickBt4(View view) {
        if (next)
            Toast.makeText(getApplicationContext(), "Naciśnij pytanie by przejść dalej", Toast.LENGTH_SHORT).show();
        if (!next)
            checkAnswers((int) mOdp4.getTag(), 4);

    }


    class GetZestawTask extends AsyncTask<Void, Void, Void> {


        protected Void doInBackground(Void... u) {
            if (db == null) {
                db = Omnibus.getSingelton();
                mZestaw = db.getZestaw();
            }
            return null;
        }

        protected void onPostExecute(Void v) {
            max = mZestaw.size();
            startGame();
        }
    }

    class SendDataTask extends AsyncTask<Void, Void, Void> {


        protected Void doInBackground(Void... u) {

                db = Omnibus.getSingelton();
                db.setMyScore(new Wynik(mUserId, points));

            return null;
        }

        protected void onPostExecute(Void v) {
        new GameActivity.GetTop10Task().execute();
        }
    }

    class GetTop10Task extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... u) {
            db = Omnibus.getSingelton();
            db.getTop10();
            return null;
        }

        protected void onPostExecute(Void v) {
        }
    }
}
