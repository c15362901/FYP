package com.example.barang.wanderlust;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by barang on 20/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //name of database
    public static final String DATABASE_NAME = "wanderlust.db";
    private static final int DATABASE_VERSION = 4;

    //names of tables
    public static final String USERS_TABLE = "UsersTable";
    public static final String ITINERARY_TABLE = "ItineraryTable";
    public static final String MY_TRIP = "MyTrip";

    //UsersTable Columns
    public static final String COL_USERS = "USERNAME";
    public static final String COL_PASSWORD = "PASSWORD";
    public static final String COL_USERID = "USERID";
    public static final String COL_FIRSTNAME = "FIRSTNAME";
    public static final String COL_LASTNAME = "LASTNAME";
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_NUMBER = "NUMBER";


    public static final String COL_TRIPID = "TRIPID";
    public static final String COL_TRIPNAME = "TRIPNAME";
    public static final String COL_TRIPDATE = "TRIPDATE";
    public static final String COL_TRIPLAT = "TRIPLAT";
    public static final String COL_TRIPLNG = "TRIPLNG";
    public static final String COL_TRIPPOLARITY = "TRIPPOLARITY";
    public static final String COL_TRIPCATEGORY = "TRIPCATEGORY";
    public static final String COL_TRIPADDRESS = "TRIPADDRESS";

    public static final String MY_TRIPID = "MYTRIPID";
    public static final String MY_TRIPTITLE = "MYTRIPTITLE";
    public static final String MY_TRIPNAME = "MYTRIPNAME";
    public static final String MY_TRIPDATE = "MYTRIPDATE";
    public static final String MY_TRIPLAT = "MYTRIPLAT";
    public static final String MY_TRIPLNG = "MYTRIPLNG";
    public static final String MY_TRIPPOLARITY = "MYTRIPPOLARITY";
    public static final String MY_TRIPCATEGORY = "MYTRIPCATEGORY";
    public static final String MY_TRIPADDRESS = "MYTRIPADDRESS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USERS_TABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT, FIRSTNAME TEXT, LASTNAME TEXT, EMAIL TEXT, NUMBER TEXT)");
        db.execSQL("create table " + ITINERARY_TABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, TRIPNAME TEXT, TRIPDATE TEXT, TRIPLAT DOUBLE, TRIPLNG DOUBLE, TRIPPOLARITY INT, TRIPCATEGORY TEXT, TRIPADDRESS TEXT)");
        db.execSQL("create table " + MY_TRIP + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, MYTRIPTITLE TEXT, MYTRIPNAME TEXT, MYTRIPDATE TEXT, MYTRIPLAT DOUBLE, MYTRIPLNG DOUBLE, MYTRIPPOLARITY INT, MYTRIPCATEGORY TEXT, MYTRIPADDRESS TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ITINERARY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MY_TRIP);
        onCreate(db);

    }


    /**************************************************************************************************************************************************
     METHODS OF UsersTable
     **************************************************************************************************************************************************/


    //inserts data into the UsersTable
    void insertData(String username, String password, String firstname, String lastname, String email, String number, int usertype) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERS, username);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_FIRSTNAME, firstname);
        contentValues.put(COL_LASTNAME, lastname);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_NUMBER, number);
        db.insert(USERS_TABLE, null, contentValues);

    }

    //will check if the user already exists or if the username is taken - Used in the REGISTERNOW CLASS
    boolean checkUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        } else {
            return false;
        }
    }


    //checks if the username is in the database - used in the MAINACTIVITY CLASS
    String checkUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "Username doesn't exist.";
        }

        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        return password;

    }


    String getPhone(String username) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String userphone = cursor.getString(cursor.getColumnIndex("NUMBER"));
            return userphone;
        } else {
            return "";
        }
    }

    String getEmail(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String useremail = cursor.getString(cursor.getColumnIndex("EMAIL"));
            return useremail;
        } else {
            return "";
        }
    }

    String getName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String userfname = cursor.getString(cursor.getColumnIndex("FIRSTNAME"));
            return userfname;
        } else {
            return "";
        }
    }

    String getLName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String userlname = cursor.getString(cursor.getColumnIndex("LASTNAME"));
            return userlname;
        } else {
            return "";
        }
    }

    String getUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String user = cursor.getString(cursor.getColumnIndex("USERNAME"));
            return user;
        } else {
            return "";
        }
    }

    void updateNumber(String username, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NUMBER, number);
        db.update(USERS_TABLE, contentValues, "USERNAME = ?", new String[]{username});
    }


    void updateEmail(String username, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, email);
        db.update(USERS_TABLE, contentValues, "USERNAME = ?", new String[]{username});
    }

    void addItinerary(String tripname, String tripaddress, String tripcategory, String tripdate, String triplat, String triplng)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TRIPNAME, tripname);
        contentValues.put(COL_TRIPADDRESS, tripaddress);
        contentValues.put(COL_TRIPCATEGORY, tripcategory);
        contentValues.put(COL_TRIPDATE, tripdate);
        contentValues.put(COL_TRIPLAT, triplat);
        contentValues.put(COL_TRIPLNG, triplng);

        db.insert(ITINERARY_TABLE, null, contentValues);
    }


    void deleteItemFromItinerary(String tripname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ITINERARY_TABLE + " WHERE "+COL_TRIPNAME+"='"+tripname+"'");

        db.close();
    }

    public Cursor getMorningItinerary(String tripdate) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("ItineraryTable",
                new String[] {"_id",COL_TRIPNAME,COL_TRIPADDRESS,COL_TRIPDATE, COL_TRIPCATEGORY},
                COL_TRIPCATEGORY + "=?" + " AND " + COL_TRIPDATE + "=?",
                new String[]{"Morning",tripdate},
                null,
                null,
                null);

        return cursor;
    }

    public Cursor getAfternoonItinerary(String tripdate) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("ItineraryTable",
                new String[] {"_id",COL_TRIPNAME,COL_TRIPADDRESS,COL_TRIPDATE, COL_TRIPCATEGORY},
                COL_TRIPCATEGORY + "=?" + " AND " + COL_TRIPDATE + "=?",
                new String[]{"Afternoon",tripdate},
                null,
                null,
                null);

        return cursor;
    }

    public Cursor getEveningItinerary(String tripdate) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("ItineraryTable",
                new String[] {"_id",COL_TRIPNAME,COL_TRIPADDRESS,COL_TRIPDATE, COL_TRIPCATEGORY},
                COL_TRIPCATEGORY + "=?" + " AND " + COL_TRIPDATE + "=?",
                new String[]{"Evening",tripdate},
                null,
                null,
                null);
        return cursor;
    }


    public ArrayList<String> getAllStringValues() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> yourStringValues = new ArrayList<String>();
        Cursor result = db.query(true, "ItineraryTable",
                new String[] {COL_TRIPDATE}, null, null, null, null,
                null, null);

        if (result.moveToFirst()) {
            do {
                yourStringValues.add(result.getString(result
                        .getColumnIndex(COL_TRIPDATE)));
            } while (result.moveToNext());
        } else {
            return null;
        }
        return yourStringValues;
    }

    public Cursor getTrip(String tripdate) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("ItineraryTable",
                new String[] {"_id",COL_TRIPNAME,COL_TRIPADDRESS,COL_TRIPDATE, COL_TRIPCATEGORY, COL_TRIPLAT, COL_TRIPLNG},
                COL_TRIPDATE + "=?",
                new String[]{tripdate},
                null,
                null,
                null);

        return cursor;
    }


    boolean isItem(String tripName, String tripDate, String tripCategory){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("ItineraryTable",null,COL_TRIPNAME + "=?" + " AND " + COL_TRIPDATE + "=?" + " AND " + COL_TRIPCATEGORY + "=?",new String[]{tripName, tripDate,tripCategory},null,null,null);

        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }

    }

    boolean checkTrip() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ItineraryTable",null);
        if(cursor.getCount()>0){
            cursor.close();
            return false;
        }else{
            //cart is empty
            return true;
        }
    }

    boolean checkDate(String tripdate){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("ItineraryTable",null,COL_TRIPDATE + "=?",new String[]{tripdate},null,null,null);
        if(cursor.getCount()>0){
            cursor.close();
            return true;
        }
        else{
            return false;
        }
    }

    void addToTrip(String triptitle, String tripdate, String tripname, String tripaddress, String tripcategory, String triplat, String triplng)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MY_TRIPTITLE, triptitle);
        contentValues.put(MY_TRIPDATE, tripdate);
        contentValues.put(MY_TRIPNAME, tripname);
        contentValues.put(MY_TRIPADDRESS, tripaddress);
        contentValues.put(MY_TRIPCATEGORY, tripcategory);
        contentValues.put(MY_TRIPLAT, triplat);
        contentValues.put(MY_TRIPLNG, triplng);

        db.insert(MY_TRIP, null, contentValues);
    }

    public Cursor getMyTrips() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("MyTrip",
                new String[] {"_id",MY_TRIPTITLE, MY_TRIPDATE, MY_TRIPNAME, MY_TRIPADDRESS,MY_TRIPCATEGORY,MY_TRIPLAT,MY_TRIPLNG},
                null,
                null,
                MY_TRIPDATE,
                null,
                MY_TRIPDATE);

        return cursor;
    }

    boolean checkMyTrip() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MyTrip",null);
        if(cursor.getCount()>0){
            cursor.close();
            return false;
        }else{
            //cart is empty
            return true;
        }
    }

    public Cursor getMyTripDate(String tripdate) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("MyTrip",
                new String[] {"_id",MY_TRIPTITLE,MY_TRIPNAME,MY_TRIPADDRESS,MY_TRIPDATE, MY_TRIPCATEGORY, MY_TRIPLAT, MY_TRIPLNG},
                MY_TRIPDATE + "=?",
                new String[]{tripdate},
                null,
                null,
                null);

        return cursor;
    }



}
