package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE myemployee(sno INTEGER PRIMARY KEY, name TEXT, increment TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"myemployee"});
        onCreate(db);
    }

    public void addEmployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", emp.getName());
        values.put("increment", emp.getIncrement());
        long k = db.insert("myemployee", null, values);
        Log.d("myTag", Long.toString(k));
        db.close();
    }

    public void getEmployee(int sno){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("myemployee", new String[]{"sno", "name", "increment"},
                "sno=?", new String[]{String.valueOf(sno)}, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("myTag name", cursor.getString(1));
            Log.d("myTag increment", cursor.getString(2));
        }
        else{
            Log.e("mytag", "SOME ERROR ACCURED");
        }
    }
}
