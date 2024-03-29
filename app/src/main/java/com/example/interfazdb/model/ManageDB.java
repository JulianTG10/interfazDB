package com.example.interfazdb.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ManageDB extends SQLiteOpenHelper {

    private static final String DATA_BASE_USERS = "dbUsers";
    private static final int VERSION = 1;
    private static final String TABLA_USERS ="users";

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLA_USERS+"(usu_document INTEGER PRIMARY KEY," +
            ""+"usu_users varchar(35) NOT NULL, usu_names varchar(100) NOT NULL, usu_last_names varchar(100) " +
            "NOT NULL,"+"usu_pass varchar(20) NOT NULL);";
    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS"+ TABLA_USERS;








    public ManageDB(@Nullable Context context) {
        super(context, DATA_BASE_USERS, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.i("DATABASE","se creo la tabla"+CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE);
        onCreate(sqLiteDatabase);

    }


}
