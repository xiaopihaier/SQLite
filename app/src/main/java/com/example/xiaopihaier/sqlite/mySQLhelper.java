package com.example.xiaopihaier.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 背书包的小屁孩儿 on 16-12-28.
 */

public class mySQLhelper extends SQLiteOpenHelper {

    //创建数据库
    public static final String SQLName="create table table_name("
                        +"id integer primary  key autoincrement,"
                        +"info text)";
    private Context mcontext;

    public mySQLhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLName);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
