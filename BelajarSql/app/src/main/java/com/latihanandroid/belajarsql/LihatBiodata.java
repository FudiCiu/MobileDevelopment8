package com.latihanandroid.belajarsql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbhelper;
    Button btn2;
    TextView text1,text2,text3,text4,text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);
        dbhelper= new DataHelper(this);
        text1=(TextView) findViewById(R.id.textView1);
        text2=(TextView) findViewById(R.id.textView2);
        text3=(TextView) findViewById(R.id.textView3);
        text4=(TextView) findViewById(R.id.textView4);
        text5=(TextView) findViewById(R.id.textView5);
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        cursor= db.rawQuery("Select * from biodata where nama='"+getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        btn2=(Button) findViewById(R.id.button1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
