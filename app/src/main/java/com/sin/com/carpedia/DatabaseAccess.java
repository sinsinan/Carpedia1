package com.sin.com.carpedia;

/**
 * Created by sin on 7/9/16.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
public class DatabaseAccess {


    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */

    public String[] getQuotename(String value) {

        List<String> namel = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select * from CARINFO where SEARCH like '"+value+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            namel.add(cursor.getString(1));
            cursor.moveToNext();

        }
        cursor.close();

        String[] name = new String[namel.size()];
        name = namel.toArray(name);

        return name;
    }


    public String[] getQuotecompany(String value) {

        List<String> companyl = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select * from CARINFO where SEARCH like '"+value+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            companyl.add(cursor.getString(2));
            cursor.moveToNext();

        }
        cursor.close();
        String[] company = new String[companyl.size()];
        company = companyl.toArray(company);
        return company;
    }


    public List<Integer> getQuoteimageid(String value, Context context) {
        List<Integer> imageidl = new ArrayList<Integer>();
        String url;
        Cursor cursor = database.rawQuery("select * from CARINFO where SEARCH like '"+value+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            url = "car" + cursor.getString(0) + "";
            imageidl.add(context.getResources().getIdentifier(url, "drawable", DatabaseAccess.class.getPackage().getName()));

            cursor.moveToNext();

        }
        cursor.close();

        return imageidl;

    }


    public String[] getQuoteprice(String value) {

        List<String> pricel = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select * from CARINFO where SEARCH like '"+value+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            pricel.add("Price :" + cursor.getString(4));
            cursor.moveToNext();

        }
        cursor.close();
        String[] price = new String[pricel.size()];
        price = pricel.toArray(price);
        return price;


    }

    public String[] getQuotenamef(String types,String companys,String prices,String transmissions,String fuels)
    {
        List<String> namel = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select * from CARINFO where CATEGORY like '"+types+"' and COMPANY like '"+companys+"' and PRICE "+prices+" and TRANSMISSION like '"+transmissions+"' and FUEL like '"+fuels+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            namel.add(cursor.getString(1));
            cursor.moveToNext();

        }
        cursor.close();

        String[] name = new String[namel.size()];
        name = namel.toArray(name);

        return name;
    }



    public String[] getQuotecompanyf(String types,String companys,String prices,String transmissions,String fuels) {

        List<String> companyl = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select * from CARINFO where CATEGORY like '"+types+"' and COMPANY like '"+companys+"' and PRICE "+prices+" and TRANSMISSION like '"+transmissions+"' and FUEL like '"+fuels+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            companyl.add(cursor.getString(2));
            cursor.moveToNext();

        }
        cursor.close();
        String[] company = new String[companyl.size()];
        company = companyl.toArray(company);
        return company;
    }


    public List<Integer> getQuoteimageidf(String types,String companys,String prices,String transmissions,String fuels,Context context) {
        List<Integer> imageidl = new ArrayList<Integer>();
        String url;
        Cursor cursor = database.rawQuery("select * from CARINFO where CATEGORY like '"+types+"' and COMPANY like '"+companys+"' and PRICE "+prices+" and TRANSMISSION like '"+transmissions+"' and FUEL like '"+fuels+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            url = "car" + cursor.getString(0) + "";
            imageidl.add(context.getResources().getIdentifier(url, "drawable", DatabaseAccess.class.getPackage().getName()));

            cursor.moveToNext();

        }
        cursor.close();

        return imageidl;

    }


    public String[] getQuotepricef(String types,String companys,String prices,String transmissions,String fuels) {

        List<String> pricel = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select * from CARINFO where CATEGORY like '"+types+"' and COMPANY like '"+companys+"' and PRICE "+prices+" and TRANSMISSION like '"+transmissions+"' and FUEL like '"+fuels+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            pricel.add("Price :" + cursor.getString(4));
            cursor.moveToNext();

        }
        cursor.close();
        String[] price = new String[pricel.size()];
        price = pricel.toArray(price);
        return price;


    }


    public String[] getQuotedata(String name) {

        List<String> datalist = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select * from CARINFO where NAME like '"+name+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            for (int i = 0; 1 < 14; i++) {
                datalist.add(cursor.getString(i));
            }


        }
        cursor.close();

        String[] data = new String[datalist.size()];
        data = datalist.toArray(data);

        return data;

    }
}