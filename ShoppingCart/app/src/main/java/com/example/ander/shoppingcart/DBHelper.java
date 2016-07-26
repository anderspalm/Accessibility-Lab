package com.example.ander.shoppingcart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {

    // instantiating item type table variables
    private static final String TYPE_TABLE_NAME = "type_table_name";
    private static final String TYPE_ID = "_id";
    private static final String TYPE_NAME = "name";

    // instantiating item type table variables
    private static final String ITEM_TABLE_NAME = "item_table_name";
    private static final String ITEM_ID = "item_id";
    private static final String ITEM_NAME = "item_name";
    private static final String ITEM_DESCRIPTION = "item_description";
    private static final String ITEM_PRICE = "item_price";

    // instantiating item type table variables
    private static final String CART_TABLE_NAME = "cart_table_name";
    private static final String CART_ID = "cart_id";

    // making this activity a Singleton
    private DBHelper(Context context) {
        super(context, "db", null, 1);
    }

    // creating the tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TYPE_TABLE);
        sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);
        sqLiteDatabase.execSQL(CREATE_CART_TABLE);

        //adding values into table
        sqLiteDatabase.execSQL("INSERT INTO " + TYPE_TABLE_NAME + "(" + TYPE_NAME + ")" +
                " VALUES (POST MODERNIST),(VICTORIAN),(EDWARDIAN),(MODERN)");
        sqLiteDatabase.execSQL("INSERT INTO " + ITEM_TABLE_NAME + "(" + ITEM_NAME + ", " + ITEM_DESCRIPTION + ", " + ITEM_PRICE + ")" +
                " VALUES " +
                "(20 St. John Road, 3 bedroom home with garden, 2-500-000)," +
                "(2 Eaton Square, 6 bedroom home with garden, 5-750-000)," +
                "(90 Warrick Road, 2 bedroom home with garden, 1-500-000)," +
                "(50 John's Park, 1 bedroom home with garden, 1-000-000)");
    }

    // removing and recreating the tables
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_CART_TABLE);
        sqLiteDatabase.execSQL(DELETE_ITEM_TABLE);
        sqLiteDatabase.execSQL(DELETE_TYPE_TABLE);
        onCreate(sqLiteDatabase);
    }

    // creating table 1
    private static final String CREATE_TYPE_TABLE = "CREATE " +
            TYPE_TABLE_NAME + " ( " +
            TYPE_ID + " INTEGER PRIMARY KEY NOT NULL, " +
            TYPE_NAME + " TEXT NOT NULL )";

    // creating table 2 - inner table to 1
    private static final String CREATE_ITEM_TABLE = "CREATE " +
            ITEM_TABLE_NAME + " ( " +
            ITEM_ID + " INTEGER PRIMARY KEY NOT NULL" +
            ITEM_NAME + " TEXT, " +
            ITEM_DESCRIPTION + " TEXT, " +
            ITEM_PRICE + " INTEGER, " +
            TYPE_ID + " INTEGER, " +
            "FOREIGN KEY (" + TYPE_ID + ") REFERENCES " +
            TYPE_TABLE_NAME + " (" + ITEM_TABLE_NAME + ") ";

    // creating shopping cart table - inner table to 2
    private static final String CREATE_CART_TABLE = " CREATE " +
            CART_ID + " INTEGER PRIMARY KEY NOT NULL, " +
            ITEM_ID + " INTEGER " +
            "FOREIGN KEY (" + ITEM_ID + ") REFERENCES " +
            ITEM_TABLE_NAME + "(" +  ITEM_ID + ")";

    // creating removal methods for the tables
    private static final String DELETE_TYPE_TABLE = " DROP TABLE IF EXISTS " + TYPE_TABLE_NAME;
    private static final String DELETE_ITEM_TABLE = " DROP TABLE IF EXISTS " + TYPE_TABLE_NAME;
    private static final String DELETE_CART_TABLE = " DROP TABLE IF EXISTS " + CART_TABLE_NAME;

}
