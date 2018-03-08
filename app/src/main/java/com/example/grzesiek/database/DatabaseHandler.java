package com.example.grzesiek.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    //database verion
    private static final int DATABASE_VERSION = 1;

    //database name
    private static final String DATABASE_NAME = "databaseApp";

    //information tabele name
    private static final String TABLE_INFORMATION = "information";

    //information table columns name
    private static final String INF_ID = "id";
    private static final String INF_NAME = "name";
    private static final String INF_HEIGHT = "height";
    private static final String INF_WEIGHT = "weight";
    private static final String INF_TARGETWEIGHT = "targetWeight";
    private static final String INF_AGE = "age";
    private static final String WG_YEAR = "WGyear";




    public DatabaseHandler(MainActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating tables

    @Override
    public void onCreate(SQLiteDatabase db) {
        //information table
        String CREATE_INFROMATION_TABLE = "CREATE TABLE " + TABLE_INFORMATION + "("
                + INF_ID + " INTEGER PRIMARY KEY," + INF_NAME + " TEXT,"
                + INF_HEIGHT + " INT," + INF_WEIGHT + " REAL,"
                + INF_TARGETWEIGHT + " REAL," + INF_AGE + " INT,"
                + WG_YEAR + " INT" + ")";
        db.execSQL(CREATE_INFROMATION_TABLE);


    }


    //upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFORMATION);


        //create tables again
        onCreate(db);
    }

//information CRUD operation (Create, Read, Update, Delete)

    //adding new information
    void addInformation(information information) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(INF_NAME, information.getName());
        values.put(INF_HEIGHT, information.getHeight());
        values.put(INF_WEIGHT, information.getWeight());
        values.put(INF_TARGETWEIGHT, information.getTargetWeight());
        values.put(INF_AGE, information.getAge());
        values.put(WG_YEAR, information.getYear());
        db.insert(TABLE_INFORMATION, null, values);
        db.close();
    }

    //gettign single infomration
    information getInformation(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_INFORMATION, new String[]{INF_ID, INF_NAME,
                        INF_HEIGHT, INF_WEIGHT, INF_TARGETWEIGHT, INF_AGE, WG_YEAR}, INF_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        information information = new information(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                Double.parseDouble(cursor.getString(3)), Double.parseDouble(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)));
        return information;
    }

    //getting all infortmacion
    public List<information> getAllInformation() {
        List<information> informationList = new ArrayList<information>();
        String selectQuery = "SELECT * FROM " + TABLE_INFORMATION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                information information = new information();
                information.setId(Integer.parseInt(cursor.getString(0)));
                information.setName(cursor.getString(1));
                information.setHeight(Integer.parseInt(cursor.getString(2)));
                information.setWeight(Double.parseDouble(cursor.getString(3)));
                information.setTargetWeight(Double.parseDouble(cursor.getString(4)));
                information.setAge(Integer.parseInt(cursor.getString(5)));
                information.setYear(Integer.parseInt(cursor.getString(6)));

                informationList.add(information);
            } while (cursor.moveToNext());
        }
        return informationList;
    }

    //updating single information
    public int updateInformation(information information) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(INF_NAME, information.getName());
        values.put(INF_HEIGHT, information.getHeight());
        values.put(INF_WEIGHT, information.getWeight());
        values.put(INF_TARGETWEIGHT, information.getTargetWeight());
        values.put(INF_AGE, information.getAge());
        values.put(WG_YEAR, information.getYear());

        //updating row
        return db.update(TABLE_INFORMATION, values, INF_ID + " = ?",
                new String[]{String.valueOf(information.getId())});
    }

    //Deleting single information
    public void deleteInformation(information information) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INFORMATION, INF_ID + " = ?",
                new String[]{String.valueOf(information.getId())});
        db.close();
    }



}
