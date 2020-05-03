package com.example.sqlitelogin.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	static String name="user.db";
	static int dbVersion=1;
	public DatabaseHelper(Context context) {
		super(context, name, null, dbVersion);
	}

	public void onCreate(SQLiteDatabase db) {
		String sql="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
		db.execSQL(sql);
		String sql2 = "create table bottle(bottleId INTEGER primary key autoincrement, usernameF varchar(20), date varchar(20), usernameR varchar(20), content TEXT)";
		db.execSQL(sql2);
		String sql3 = "CREATE TABLE IF NOT EXISTS CommentDTB" +
				" (commentID INTEGER primary key autoincrement, BottleID INTEGER, dateC String, genderC TEXT, comment TEXT, usernameC TEXT)";
		db.execSQL(sql3);
		String sql4 = "CREATE TABLE IF NOT EXISTS ReadhistoryDTB"  +
				" (historyId INTEGER primary key autoincrement, usernameR TEXT, bottleID INTEGER, time String, UsernameF TEXT)";
		db.execSQL(sql4);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


	}

}
