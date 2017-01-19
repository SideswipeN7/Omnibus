package com.example.asuper.omnibus.Klasy;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by super on 07.01.2017.
 */

public final class Omnibus implements Serializable {
    static private Omnibus repo;
    public static final String UrlAddress = "http://kaczuszka-001-site1.btempurl.com/api/";
    private ArrayList<Zestaw> mZestaw;
    private ArrayList<String> mTop10;
    private ArrayList<Wynik> mMyScores;

    public boolean check10Exists(){
        if(mTop10!=null)return true;
        return false;
    }

    public String get1of10(int x) {
        return mTop10.get(x);
    }

    public ArrayList<String> getMyScores() {
        ArrayList<String> al = new ArrayList<>();
        int i=0;
        for(Wynik w : mMyScores){
            al.add("Gra: "+(i+1)+" zdobyto: "+w.getPunkty()+" punktów");
            i++;
        }
        return  al;
    }

    private Omnibus() {

    }

    public ArrayList<String> getTop10() {
        HttpURLConnection urlConnection = null;
        ArrayList<String> al = new ArrayList<>();
        try {
            URL urlToRequest = new URL(repo.UrlAddress + "Wyniks");
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream in = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                String result = "";
                while ((line = bufferedReader.readLine()) != null)
                    result += line;

                JSONArray ja = new JSONArray(result);
                for (int i = 0; i < ja.length(); i++) {
                    al.add(ja.getString(i));
                }
            }
        } catch (Exception e) {
            Log.d("getTop10 blad", e.getMessage());
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
        mTop10 = al;
        return mTop10;
    }

    public void setMyScore(Wynik w) {
        HttpURLConnection urlConnection = null;
        try {
            URL urlToRequest = new URL(repo.UrlAddress + "Wyniks");
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("PUT");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            JSONObject jo = new JSONObject();
            jo.put("IdWyniku", "");
            jo.put("IdUzytkownika", w.getIdUzytkownika());
            jo.put("Punkty", w.getPunkty());
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jo.toString());
            System.out.println(jo.toString());
            out.close();
            mMyScores.add(w);

        } catch (Exception e) {
            Log.d("setMyScore blad", e.getMessage());
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
    }


    public ArrayList<Wynik> getMyScores(int x) {
        HttpURLConnection urlConnection = null;
        ArrayList<Wynik> al = new ArrayList<>();
        try {
            URL urlToRequest = new URL(repo.UrlAddress + "Wyniks");
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            JSONObject jo = new JSONObject();
            jo.put("dane1", true);
            jo.put("dane2", x);
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jo.toString());
            System.out.println(jo.toString());
            out.close();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream in = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                String result = "";
                while ((line = bufferedReader.readLine()) != null)
                    result += line;

                JSONArray ja = new JSONArray(result);
                for (int i = 0; i < ja.length(); i++) {
                    al.add(new Wynik(ja.getJSONObject(i).getInt("IdWyniku"), x, ja.getJSONObject(i).getInt("Punkty")));
                }
            }
        } catch (Exception e) {
            Log.d("getMyScore blad", e.getMessage());
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
        mMyScores = al;
        return mMyScores;
    }

    static public Omnibus getSingelton() {
        if (repo == null) repo = new Omnibus();
        return repo;
    }

    public ArrayList<Zestaw> getZestaw() {
        if (mZestaw != null) {
            Collections.shuffle(mZestaw);
            return mZestaw;
        }

        HttpURLConnection urlConnection = null;
        ArrayList<Zestaw> al = new ArrayList<>();
        ArrayList<ArrayList<Odpowiedz>> a2 = new ArrayList<>();
        try {
            URL urlToRequest = new URL(repo.UrlAddress + "Zestaws");
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream in = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                String result = "";
                while ((line = bufferedReader.readLine()) != null)
                    result += line;

                JSONArray ja = new JSONArray(result);
                for (int i = 0; i < ja.length(); i++) {

                    al.add(new Zestaw(new Pytanie(ja.getJSONObject(i).getJSONObject("pyt").getInt("IdPytania"), ja.getJSONObject(i).getJSONObject("pyt").getInt("NrOdpPop"), ja.getJSONObject(i).getJSONObject("pyt").getString("Tekst")), new ArrayList<Odpowiedz>()));
                    al.get(i).odp.add(new Odpowiedz(ja.getJSONObject(i).getJSONArray("odp").getJSONObject(0).getInt("IdOdpowiedzi"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(0).getInt("IdPytania"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(0).getString("Tekst"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(0).getInt("NrOdpowiedzi")));
                    al.get(i).odp.add(new Odpowiedz(ja.getJSONObject(i).getJSONArray("odp").getJSONObject(1).getInt("IdOdpowiedzi"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(1).getInt("IdPytania"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(1).getString("Tekst"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(1).getInt("NrOdpowiedzi")));
                    al.get(i).odp.add(new Odpowiedz(ja.getJSONObject(i).getJSONArray("odp").getJSONObject(2).getInt("IdOdpowiedzi"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(2).getInt("IdPytania"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(2).getString("Tekst"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(2).getInt("NrOdpowiedzi")));
                    al.get(i).odp.add(new Odpowiedz(ja.getJSONObject(i).getJSONArray("odp").getJSONObject(3).getInt("IdOdpowiedzi"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(3).getInt("IdPytania"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(3).getString("Tekst"), ja.getJSONObject(i).getJSONArray("odp").getJSONObject(3).getInt("NrOdpowiedzi")));

                }
            }


        } catch (Exception e) {
            Log.d("getZestaw blad", e.getMessage());
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }

        mZestaw = al;
        return mZestaw;
    }


    public int logIn(Uzytkownik u) {
        HttpURLConnection urlConnection = null;
        ArrayList<Uzytkownik> al = new ArrayList<>();
        try {
            URL urlToRequest = new URL(repo.UrlAddress + "Uzytkowniks/");
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            JSONObject jo = new JSONObject();
            jo.put("IdUzytkownika", 0);
            jo.put("Nazwa", u.getNazwa());
            jo.put("Haslo", u.getHaslo());
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jo.toString());
            System.out.println(jo.toString());
            out.close();

            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult != HttpURLConnection.HTTP_INTERNAL_ERROR) {
                InputStream in = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                String result = "";
                while ((line = bufferedReader.readLine()) != null)
                    result += line;

                JSONObject jo1 = new JSONObject(result);

                Wiadomosc w = new Wiadomosc(jo1.getBoolean("dane1"), jo1.getInt("dane2"));

                if (w.getDane1()) {
                    return w.getDane2();
                }
            }
        } catch (Exception e) {
            Log.d("logIn blad", e.getMessage());
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
        return 0;
    }


    public boolean Register(Uzytkownik u) {
        HttpURLConnection urlConnection = null;
        try {
            URL urlToRequest = new URL(repo.UrlAddress + "Uzytkowniks");
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("PUT");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            JSONObject jo = new JSONObject();
            jo.put("Nazwa", u.getNazwa());
            jo.put("Haslo", u.getHaslo());
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jo.toString());
            System.out.println(jo.toString());
            out.close();

            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult != HttpURLConnection.HTTP_INTERNAL_ERROR) {
                InputStream in = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                String result = "";
                while ((line = bufferedReader.readLine()) != null)
                    result += line;

                JSONObject jo1 = new JSONObject(result);

                Wiadomosc w = new Wiadomosc(jo1.getBoolean("dane1"), jo1.getInt("dane2"));

                return w.getDane1();
            }


        } catch (Exception e) {
            Log.d("logIn blad", e.getMessage());
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
        return false;
    }


}
