package com.example.saurabhsr.tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by saurabh.sr on 3/5/2016.
 */
public class DBSqlOpenHelper extends SQLiteOpenHelper {

    public DBSqlOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBHelper.DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");

// Upgrade the existing database to conform to the new version. Multiple
// previous versions can be handled by comparing _oldVersion and _newVersion
// values.
// The simplest case is to drop the old table and create a new one.
        db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
// Create a new one.
        onCreate(db);
    }
}
