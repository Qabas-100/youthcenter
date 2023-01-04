package com.example.qyonthcenter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Qdatabasee extends SQLiteOpenHelper
{
    public static final String qdatanamq="Qabspro.db";
    public static final String TapNa="youthcenter";
    public static final String qco1="qname94";
    public static final String qco2="qphOne94";
    public static final String qco3="qEmAil94";
    public static final String qco4="qATYpe94";
    public static final String qco5="qHouR94";
    public static final String qco6="qPriCe94";


    public Qdatabasee(Context context)
    {
        super(context,qdatanamq,null,1);
    }
    public void onCreate(SQLiteDatabase DQB)
    {
        DQB.execSQL("create table " +TapNa+ "(qname94 TEXT,qphOne94 INTEGER,qEmAil94 TEXT, qATYpe94 TEXT,  qHouR94 INTEGER,qPriCe94 INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DQB, int oldVersion, int newVersion)
    {
        DQB.execSQL("DROP TABLE IF EXISTS " + TapNa);
        onCreate(DQB);
    }

    public boolean QIN(String qname94, String qphOne94, String qEmAil94 , String qATYpe94, String qHouR94,String qPriCe94)
    {
        SQLiteDatabase DQB=this.getReadableDatabase();
        ContentValues CQVAL=new ContentValues();
        CQVAL.put(qco1,qname94);
        CQVAL.put(qco2,qphOne94);
        CQVAL.put(qco3,qEmAil94);
        CQVAL.put(qco4,qATYpe94);
        CQVAL.put(qco5,qHouR94);
        CQVAL.put(qco6,qPriCe94);
        long nm=DQB.insert(TapNa,null,CQVAL);
        if(nm==-1)
            return false;
        else
            return true;
    }
    public boolean QUP(String qname94, String qphOne94, String qEmAil94 , String qATYpe94, String qHouR94,String qPriCe94)
    {
        SQLiteDatabase DQB=this.getWritableDatabase();
        ContentValues CQVAL=new ContentValues();
        CQVAL.put(qco1,qname94);
        CQVAL.put(qco2,qphOne94);
        CQVAL.put(qco3,qEmAil94);
        CQVAL.put(qco4,qATYpe94);
        CQVAL.put(qco5,qHouR94);
        CQVAL.put(qco6,qPriCe94);
        DQB.update(TapNa,CQVAL,"qphOne94=?",new String[]{qphOne94});
        return true;
    }

    public Integer QDL(String qph594)
    {
        SQLiteDatabase DQB=this.getWritableDatabase();
        return DQB.delete(TapNa,"qphOne94=?",new String[]{qph594});
    }

    public Cursor getAllData()
    {
        SQLiteDatabase DQB=this.getWritableDatabase();
        Cursor cursor=DQB.rawQuery("select * from " +TapNa,null);
        return cursor;
    }


}


