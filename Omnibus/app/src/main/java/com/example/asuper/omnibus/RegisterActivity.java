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

public class RegisterActivity extends AppCompatActivity {
    EditText login;
    EditText haslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();
    }

    public void onClickRejestruj(View view) {
        login = (EditText) findViewById(R.id.EtNewUser);
        haslo = (EditText) findViewById(R.id.EtNewPassword);

        if (login.getText().length() > 24) {
            Toast.makeText(getApplicationContext(), "Zbyt długa nazwa użytkownika", Toast.LENGTH_SHORT).show();
        }
        if (login.getText().length() < 3) {
            Toast.makeText(getApplicationContext(), "Zbyt krótka nazwa użytkownika", Toast.LENGTH_SHORT).show();
        }
        if (haslo.getText().length() > 24) {
            Toast.makeText(getApplicationContext(), "Zbyt długie hasło użytkownika", Toast.LENGTH_SHORT).show();
        }
        if (haslo.getText().length() < 3) {
            Toast.makeText(getApplicationContext(), "Zbyt krótkie hasło użytkownika", Toast.LENGTH_SHORT).show();
        } else {
            Uzytkownik u = new Uzytkownik(login.getText().toString(), haslo.getText().toString());
            new RegisterActivity.RegisterTask().execute(u);
        }

    }
    public void onClickExit(View view){
        finish();
    }

    class RegisterTask extends AsyncTask<Uzytkownik, Void, Void> {
        boolean zalogowany;

        protected Void doInBackground(Uzytkownik... u) {
            Omnibus db = Omnibus.getSingelton();
            zalogowany = db.Register(u[0]);
            return null;
        }

        protected void onPostExecute(Void v) {
            if (zalogowany) {
                Toast.makeText(getApplicationContext(), "Zarejestrowano!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Taki użytkownik już istnieje!", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
