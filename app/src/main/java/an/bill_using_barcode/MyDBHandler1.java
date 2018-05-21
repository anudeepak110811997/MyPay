package an.bill_using_barcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anudeepak on 25-12-2017.
 */

public class MyDBHandler1 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABSE_NAME="items.db";
    public static final String TABLE="item";
    public static final String COLOUMN_ID="_id";
    public static final String COLOUMN_NAME="name";
    public static final String COLOUMN_PRICE="price";
    public static final String COLOUMN_EXPIRY="expiry";



    public MyDBHandler1(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

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

                COLOUMN_ID + " INTEGER PRIMARY KEY, " +
                COLOUMN_NAME + " TEXT, " +
                COLOUMN_PRICE + " TEXT, " +
                COLOUMN_EXPIRY + " TEXT " +
                ");";

        db.execSQL(query);

    }

    public void addDetails(int n,String a,String b,String c)

    {

        ContentValues values = new ContentValues();
        values.put(COLOUMN_ID,n);
        values.put(COLOUMN_NAME,a);
        values.put(COLOUMN_PRICE,b);
        values.put(COLOUMN_EXPIRY,c);

        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE,null,values);
        db.close();

    }

    public String accessName(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_NAME + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("name"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("name"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    public String accessPrice(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_PRICE + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("price"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("price"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }
    public String accessDate(String a)
    {
        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE + " WHERE 1";
        String query = "SELECT " +  COLOUMN_EXPIRY + " FROM " + TABLE + " WHERE " + COLOUMN_ID + "=\"" + a + "\";";

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("expiry"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("expiry"));



            }

            c.moveToNext();

        }

        db.close();

        return dbString;
    }


}
