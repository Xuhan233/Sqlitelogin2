package com.example.sqlitelogin.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.sqlitelogin.Bottle;
import com.example.sqlitelogin.Readhistory;
import com.example.sqlitelogin.Throw_bottle;
import com.example.sqlitelogin.User;


import java.sql.Timestamp;
import java.util.ArrayList;


public class UserService {
	private DatabaseHelper dbHelper;
	public UserService(Context context){
		dbHelper=new DatabaseHelper(context);
	}

	public boolean login(String username,String password){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="select * From user where username=? and password=?";
		Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});		
		if(cursor.moveToFirst()==true){
			cursor.close();
			return true;
		}
		return false;
	}
	public boolean register(User user){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into user(username,password,age,sex) values(?,?,?,?)";
		Object obj[]={user.getUsername(),user.getPassword(),user.getAge(),user.getSex()};
		sdb.execSQL(sql, obj);	
		return true;
	}

	public boolean throwBottle(Bottle bottle) {
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql ="insert into bottle(usernameF,date,usernameR,content) values(?,?,?,?)";
		Object obj[]={bottle.getUsernameF(),bottle.getDateF(),bottle.getUsernameR(),bottle.getContent()};
		sdb.execSQL(sql, obj);
		return true;
	}

	public Bottle Pickbottle(int id){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();

		Cursor s = sdb.rawQuery(String.format("select * from bottle where bottleId like '%s'",id),null);
		//int bottleIDIndex = s.getColumnIndex("bottleID");
		int dateFIndex = s.getColumnIndex("date");
		int contentIndex = s.getColumnIndex("content");
		int usernameFIndex = s.getColumnIndex("usernameF");

		s.moveToFirst();
		// The ArrayList to save the information to return;
		String dateF = s.getString(dateFIndex);
		String content = s.getString(contentIndex);
		String usernameF = s.getString(usernameFIndex);
		String usernameR = null;

		Bottle bottle = new Bottle(usernameF,dateF,usernameR,content);

		s.close();
		sdb.close();

		return bottle;
	}
	public void historyRecord(Readhistory readhistory) {
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql = "insert into ReadhistoryDTB(usernameR, bottleId, time, UsernameF) values(?,?,?,?)";
		Object obj[]={readhistory.getUsernameR(), readhistory.getBottleID(), readhistory.getTime(), readhistory.getUsernameF()};
		sdb.execSQL(sql, obj);
	}

	public ArrayList<Readhistory> getHistory(String uname) {
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		Cursor s = sdb.rawQuery(String.format("select * from ReadhistoryDTB where UsernameR like '%s'",uname),null);

		int bottleIDIndex = s.getColumnIndex("bottleID");
		int timeIndex = s.getColumnIndex("time");
		int usernameRIndex = s.getColumnIndex("usernameR");
		int usernameFIndex = s.getColumnIndex("UsernameF");

		s.moveToFirst();

		ArrayList<Readhistory> readhistories = new ArrayList<>();

		while (!s.isAfterLast()) {

			int bottleId = s.getInt(bottleIDIndex);
			String time = s.getString(timeIndex);
			String usernameR = s.getString(usernameRIndex);
			String usernameF = s.getString(usernameFIndex);

			Readhistory readhistory = new Readhistory(usernameR, bottleId, time,usernameF);
			readhistories.add(readhistory);
			s.moveToNext();
		}
		s.close();
		sdb.close();

		return readhistories;
	}
    public ArrayList<Readhistory> getHistorymade(String uname) {
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        Cursor s = sdb.rawQuery(String.format("select * from ReadhistoryDTB where UsernameF like '%s'",uname),null);

        int bottleIDIndex = s.getColumnIndex("bottleID");
        int timeIndex = s.getColumnIndex("time");
        int usernameRIndex = s.getColumnIndex("usernameR");
        int usernameFIndex = s.getColumnIndex("UsernameF");

        s.moveToFirst();

        ArrayList<Readhistory> readhistories = new ArrayList<>();

        while (!s.isAfterLast()) {

            int bottleId = s.getInt(bottleIDIndex);
            String time = s.getString(timeIndex);
            String usernameR = s.getString(usernameRIndex);
            String usernameF = s.getString(usernameFIndex);

            Readhistory readhistory = new Readhistory(usernameR, bottleId, time,usernameF);
            readhistories.add(readhistory);
            s.moveToNext();
        }
        s.close();
        sdb.close();

        return readhistories;
    }


}
