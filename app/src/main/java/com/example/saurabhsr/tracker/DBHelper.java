package com.example.saurabhsr.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

/**
 * Created by saurabh.sr on 3/3/2016.
 */
public class DBHelper {

    static final String DATABASE_NAME = "login.db";

    static final int DATABASE_VERSION = 1;

    public static final int NAME_COLUMN = 1;

    // TODO: Create public field for each column in your table.
// SQL Statement to create a new database.

    static final String DATABASE_CREATE = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME text,"+"Email text,PASSWORD text); ";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DBSqlOpenHelper dbHelper;

    public DBHelper(Context _context)
    {
        context = _context;
        dbHelper = new DBSqlOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DBHelper open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }



    public boolean insertContact  (String name, String email,String pasword)
    {

        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", name);
        contentValues.put("Email", email);
        contentValues.put("PASSWORD", pasword);
        db.insert("LOGIN", null, contentValues);
        return true;
    }




    public boolean updateContact (Integer id, String name, String email,String pasword)
    {

        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", name);
        contentValues.put("Email", email);
        contentValues.put("PASSWORD", pasword);
        db.update("LOGIN", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public int deleteEntry(String UserName)
    {

//String id=String.valueOf(ID);
        String where="name=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where, new String[]{UserName}) ;
// Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String userName)
    {

        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }


}
