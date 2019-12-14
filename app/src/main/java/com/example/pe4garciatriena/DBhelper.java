package com.example.pe4garciatriena;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    String col4 ="bCountry";
    String col1 ="bGold";
    String col2 ="bSilver";
    String col3 ="bBronze";
    String table = "medal";

    public DBhelper(@Nullable Context context) {
        super(context, "sea.db", null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create Table medal (bCountry TEXT PRIMARY KEY, bGold TEXT, bSilver TEXT, bBronze TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long insert(String bCountry, String bGold, String bSilver, String bBronze) {
        SQLiteDatabase  db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, bGold);
        cv.put(col2, bSilver);
        cv.put(col3, bBronze);
        cv.put(col4, bCountry);
        return db.insert(table, null, cv);
    }

    public int update(String bCountry, String bGold, String bSilver, String bBronze) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, bGold);
        cv.put(col2, bSilver);
        cv.put(col3, bBronze);
        cv.put(col4, bCountry);
        return db.update(table, cv, "bCountry=?", new String[]{bCountry});
    }

    public int delete(String bCountry) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table, "bCountry=?", new String[]{bCountry});
    }

    public Cursor getTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectAll = "SELECT * FROM medal";
        return db.rawQuery(selectAll, null);
    }
}

