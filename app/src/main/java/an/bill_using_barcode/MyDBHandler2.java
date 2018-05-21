package an.bill_using_barcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anudeepak on 07-01-2018.
 */

public class MyDBHandler2 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABSE_NAME="employee_login.db";
    public static final String TABLE="login";
    public static final String COLOUMN_ID="_id";
    public static final String COLOUMN_NAME="name";
    public static final String COLOUMN_GRADE="grade";
    public static final String COLOUMN_USERNAME="username";
    public static final String COLOUMN_PASSWORD="password";



    public MyDBHandler2(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABSE_NAME, factory, DATABASE_VERSION);

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+TABLE);
        onCreate(db);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE + "(" +

                COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLOUMN_NAME + " TEXT, " +
                COLOUMN_GRADE + " TEXT, " +
                COLOUMN_USERNAME + " TEXT, " +
                COLOUMN_PASSWORD + " TEXT " +
                ");";

        db.execSQL(query);

    }
    /*public void addUpdatedDetails(String a,String b,String c,String d,String e)

    {

        ContentValues values = new ContentValues();
        values.put(COLOUMN_ADDRESS1,b);
        values.put(COLOUMN_ADDRESS2,c);
        values.put(COLOUMN_ADDRESS3,d);
        values.put(COLOUMN_ADDRESS4,e);


        SQLiteDatabase db= getWritableDatabase();
        db.update(TABLE,values,COLOUMN_ID+"="+a,null);
        db.close();

    }*/

    public void addDetails(String a,String b,String c,String d)

    {

        ContentValues values = new ContentValues();
        values.put(COLOUMN_NAME,a);
        values.put(COLOUMN_GRADE,b);
        values.put(COLOUMN_USERNAME,c);
        values.put(COLOUMN_PASSWORD,d);

        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE,null,values);
        db.close();

    }

    public String accessDetails(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_PASSWORD + " FROM " + TABLE + " WHERE " + COLOUMN_USERNAME + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("password"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("password"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    public String accessId(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_ID + " FROM " + TABLE + " WHERE " + COLOUMN_USERNAME + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("_id"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("_id"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    /*public String accessName(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_USERNAME + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("username"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("username"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    public String accessAd1(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_ADDRESS1 + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("address1"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("address1"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    public String accessAd2(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_ADDRESS2 + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("address2"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("address2"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    public String accessAd3(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_ADDRESS3 + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("address3"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("address3"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    public String accessAd4(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_ADDRESS4 + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("address4"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("address4"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }*/

}

