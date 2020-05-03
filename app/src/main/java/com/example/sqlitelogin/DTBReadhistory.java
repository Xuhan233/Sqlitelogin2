//package com.example.sqlitelogin;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//
//public class DTBReadhistory {
//    private static SQLiteDatabase sqLiteDatabase;
//
//
//    public void DTBBottle(SQLiteDatabase sqLiteDatabase) {
//
//        this.sqLiteDatabase = sqLiteDatabase;
//    }
//
//    public static void createTable() {
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ReadhistoryDTB"  +
//                " (historyId INTEGER PRIMARY KEY, usernameR TEXT, bottleID INTEGER, time DATE, UsernameF TEXT)");
//
//    }
//
//    /**
//     * count the time the bottle have be read
//     * Check the history record of the bottle read
//     * @param ID
//     * @return
//     */
//    public static ArrayList<Readhistory> getHistoryByUsernameF(String username) {
//        createTable();
//
//        String q1 = "SELECT * FROM ReadhistoryDTB WHERE usernameF = username";
//        Cursor s = sqLiteDatabase.rawQuery(q1, null);
//
//        int bottleIDIndex = s.getColumnIndex("bottleID");
//        int timeIndex = s.getColumnIndex("time");
//        int usernameRIndex = s.getColumnIndex("usernameR");
//        int usernameFIndex = s.getColumnIndex("usernameF");
//
//        s.moveToFirst();
//
//        ArrayList<Readhistory> readhistories = new ArrayList<>();
//
//        while (!s.isAfterLast()) {
//
//            int bottleID = s.getInt(bottleIDIndex);
//            String time = Timestamp.valueOf(s.getString(timeIndex));
//            String usernameR = s.getString(usernameRIndex);
//            String usernameF = s.getString(usernameFIndex);
//
//            // The ArrayList to save the information to return;
//            Readhistory readhistory = new Readhistory(usernameR, bottleID, time, usernameF);
//            readhistories.add(readhistory);
//            s.moveToNext();
//        }
//        s.close();
//        sqLiteDatabase.close();
//
//        return readhistories;
//    }
//
//    /**
//     * Check the bottle you have read before;
//     * @param username
//     * @return
//     */
//    public static ArrayList<Readhistory> getHistoryByUsernameR(String username) {
//        createTable();
//
//        String q1 = "SELECT * FROM ReadhistoryDTB WHERE usernameR = usernameF";
//        Cursor s = sqLiteDatabase.rawQuery(q1, null);
//
//        int bottleIDIndex = s.getColumnIndex("bottleID");
//        int timeIndex = s.getColumnIndex("time");
//        int usernameRIndex = s.getColumnIndex("usernameR");
//        int usernameFIndex = s.getColumnIndex("usernameF");
//
//        s.moveToFirst();
//
//        ArrayList<Readhistory> readhistories = new ArrayList<>();
//
//        while (!s.isAfterLast()) {
//
//            int bottleId = s.getInt(bottleIDIndex);
//            Timestamp time = Timestamp.valueOf(s.getString(timeIndex));
//            String usernameR = s.getString(usernameRIndex);
//            String usernameF = s.getString(usernameFIndex);
//
//            // The ArrayList to save the information to return;
//            Readhistory readhistory = new Readhistory(usernameR, bottleId, time,usernameF);
//            readhistories.add(readhistory);
//            s.moveToNext();
//        }
//        s.close();
//        sqLiteDatabase.close();
//
//        return readhistories;
//
//    }
//}
