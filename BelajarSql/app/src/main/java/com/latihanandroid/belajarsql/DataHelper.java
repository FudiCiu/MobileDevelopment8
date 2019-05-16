package com.latihanandroid.belajarsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="biodatadiri.db";
    private static final int VERSION=1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "create table biodata (no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data","onCreate");
        sqLiteDatabase.execSQL(sql);
        sql="INSERT INTO biodata(no,nama,tgl,jk,alamat) VALUES('1','Fudi','1998-07-09','Laki-laki','Makassar')";
        sqLiteDatabase.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
