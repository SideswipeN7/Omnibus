package com.example.asuper.omnibus;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asuper.omnibus.Klasy.Omnibus;

import java.util.List;

public class MyScoresActivity extends AppCompatActivity {

    Omnibus mDb;
    ListView mLv;
    ScoresAdapter mAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scores);
        mLv = (ListView) findViewById(R.id.lvMyScores);
        //mLv.setAdapter(mAA);
        setData();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();


    }

    private void setData() {
        mDb = Omnibus.getSingelton();

        mAA = new ScoresAdapter(this,mDb.getMyScores());

        mLv.setAdapter(mAA);
        mAA.notifyDataSetChanged();

    }
    public void onClickBack(View view){
        finish();
    }

    class ScoresAdapter extends BaseAdapter {

        Context context;
        List<String> data;
        private  LayoutInflater inflater = null;

        public ScoresAdapter(Context context,  List<String> data) {
            // TODO Auto-generated constructor stub
            this.context = context;
            this.data = data;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View vi = convertView;
            if (vi == null)
                vi = inflater.inflate(R.layout.row, null);
            TextView text = (TextView) vi.findViewById(R.id.text);
            text.setText(data.get(position));;
            return vi;
        }
    }

}
