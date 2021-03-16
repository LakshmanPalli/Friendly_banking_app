package com.example.bankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHouse extends SQLiteOpenHelper {
    private String TABLE_NAME = "accounts_table";
    private String TABLE_NAME1 = "transactions_table";

    public DatabaseHouse(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    SQLiteDatabase db = this.getWritableDatabase();

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into accounts_table values(12345412,'Kirito',1000.00,'kirito@mail.com','XXXXXXXXXX256','IFC13452')");
        db.execSQL("insert into accounts_table values(21452452,'Endou',2000.00,'endou@mail.com','XXXXXXXXXX145','IFC54321')");
        db.execSQL("insert into accounts_table values(29845321,'Eren',4000.00,'eren@mail.com','XXXXXXXXXX963','IFC32541')");
        db.execSQL("insert into accounts_table values(52346963,'Livae',5000.00,'livae@mail.com','XXXXXXXXXX254','IFC56389')");
        db.execSQL("insert into accounts_table values(84521987,'Deku',6000.00,'deku@mail.com','XXXXXXXXXX451','IFC56230')");
        // TABLE with 6 rows and 6 coloumns...
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readAccountsTable(){
        Cursor cursor = db.rawQuery("select * from accounts_table", null);
        return cursor;
    }
    // to select the sender
    public Cursor readSenderData(String phonenumber){
        Cursor cursor = db.rawQuery("select * from accounts_table where phonenumber = " +phonenumber, null);
        return cursor;
    }
    // to select the reciever
    public Cursor readSelectReceiverList(String phonenumber) {
        Cursor cursor = db.rawQuery("select * from accounts_table except select * from accounts_table where phonenumber = " +phonenumber, null);
        return cursor;
    }
    // update the amount after the transactions for both(sender/receiver)
    public void updateAmount(String phonenumber, String amount){
        db.execSQL("update accounts_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readTransactionsData(){
        Cursor cursor = db.rawQuery("select * from transactions_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}