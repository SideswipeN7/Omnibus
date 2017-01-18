package com.example.asuper.omnibus;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asuper.omnibus.Klasy.Omnibus;
import com.example.asuper.omnibus.Klasy.Uzytkownik;

public class LogInActivity extends AppCompatActivity {
    EditText login;
    EditText haslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();
    }
    public void onClickZaloguj(View view) {
        login = (EditText) findViewById(R.id.EtLogin);
        haslo = (EditText) findViewById(R.id.EtPassword);
        Uzytkownik u = new Uzytkownik(login.getText().toString(), haslo.getText().toString());
        new LogInActivity.LogInTask().execute(u);
    }


    public void onClickRejestruj(View view){
        Intent intent = new Intent(LogInActivity.this,RegisterActivity.class);
        startActivity(intent);
    }


    class LogInTask extends AsyncTask<Uzytkownik, Void, Void> {
        int id;
        Omnibus db;


        protected Void doInBackground(Uzytkownik... u) {
            db = Omnibus.getSingelton();
            id = db.logIn(u[0]);
            return null;
        }

        protected void onPostExecute(Void v) {
            if (id==0) {
                Toast.makeText(getApplicationContext(), "Złe dane logowania", Toast.LENGTH_SHORT).show();
            }
            else{

                Intent intent=new Intent(LogInActivity.this,MainActivity.class);
                intent.putExtra("UserId",id);
                startActivity(intent);
            }

        }
    }

}
