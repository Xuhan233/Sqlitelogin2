//package com.example.sqlitelogin;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//
///**
// * Save the list of the bottle.
// * 1. Bottle that user send.
// * 2. Bottle that user read before.
// * The list include usernameF(bottle main from), date and gender.
// */
//public class DTBBottle {
//
//    private static SQLiteDatabase sqLiteDatabase;
//
//    public void DTBBottle(SQLiteDatabase sqLiteDatabase) {
//
//        this.sqLiteDatabase = sqLiteDatabase;
//    }
//
//    public static void createTable() {
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BottleDTB" +
//                " (bottleId INTEGER PRIMARY KEY, usernameF TEXT, date DATETIME, usernameR TEXT, content TEXT)");
//    }
//
//
//
//    /**
//     * Check the history bottle current user made.
//     *
//     * @param Username: The currently user's username.
//     * @return
//     */
//    public ArrayList<Bottle> BottleMade(String Username) {
//        createTable();
//
//        String q1 = "SELECT * FROM BottleDTB WHERE usernameF = username";
//        Cursor s = sqLiteDatabase.rawQuery(q1, null);
//
//        int bottleIDIndex = s.getColumnIndex("bottleID");
//        int dateFIndex = s.getColumnIndex("dateF");
//        int contentIndex = s.getColumnIndex("content");
//        int usernameFIndex = s.getColumnIndex("usernameF");
//
//        s.moveToFirst();
//        // The ArrayList to save the information to return;
//        ArrayList<Bottle> bottleMade = new ArrayList<>();
//
//        while (!s.isAfterLast()) {
//
//            int bottleId = s.getInt(bottleIDIndex);
//            Timestamp dateF = Timestamp.valueOf(s.getString(dateFIndex));
//            String content = s.getString(contentIndex);
//            String usernameF = s.getString(usernameFIndex);
//
//            // The ArrayList to save the information to return;
//            Bottle bottle = new Bottle( usernameF, dateF,content, bottleId);
//            bottleMade.add(bottle);
//            s.moveToNext();
//        }
//        s.close();
//        sqLiteDatabase.close();
//
//        return bottleMade;
//    }
//
//
//    public static void throwBottle(String usernameF, Timestamp dateF, String content) {
//        createTable();
//        String sql ="INSERT INTO BottleDTB(usernameF, dateF, content, bottleID) VALUES('%s','%s''%s''%s')";
//        sqLiteDatabase.execSQL(String.format(sql,
//                usernameF,dateF, content));
//    }
//
////    public long getProfilesCount() {
////
////        SQLiteDatabase db = this.getReadableDatabase();
////        long count = DatabaseUtils.queryNumEntries(db, "BottleDTB");
////        db.close();
////        return count;
////    }
//
//    /**
//     * The function with pick bottle
//     * @param id: A random number to select;
//     * @return
//     */
//    public static ArrayList<Bottle> Pickbottle(int id) {
//        createTable();
//        String sql = "SELECT * FROM BottleDTB WHERE BottleID = id";
//        Cursor s = sqLiteDatabase.rawQuery(sql,null);
//        int bottleIDIndex = s.getColumnIndex("bottleID");
//        int dateFIndex = s.getColumnIndex("dateF");
//        int contentIndex = s.getColumnIndex("content");
//        int usernameFIndex = s.getColumnIndex("usernameF");
//
//        s.moveToFirst();
//        // The ArrayList to save the information to return;
//        ArrayList<Bottle> bottleMade = new ArrayList<>();
//
//        while (!s.isAfterLast()) {
//
//            int bottleId = s.getInt(bottleIDIndex);
//            Timestamp dateF = Timestamp.valueOf(s.getString(dateFIndex));
//            String content = s.getString(contentIndex);
//            String usernameF = s.getString(usernameFIndex);
//
//            // The ArrayList to save the information to return;
//            Bottle bottle = new Bottle( usernameF, dateF,content, bottleId);
//            bottleMade.add(bottle);
//            s.moveToNext();
//        }
//        s.close();
//        sqLiteDatabase.close();
//
//        return bottleMade;
//
//    }
//
////    public ArrayList<Bottle> SelectGender(String gender) {
////        createTable();
////        String sql = "SELECT * FROM BottleDTB WHERE gender = this.gender";
////        Cursor s = sqLiteDatabase.rawQuery(sql,null);
////        int bottleIDIndex = s.getColumnIndex("bottleID");
////        //int contentIndex = c.getColumnIndex("content");
////        int dateFIndex = s.getColumnIndex("dateF");
////        int contentIndex = s.getColumnIndex("content");
////        int usernameFIndex = s.getColumnIndex("usernameF");
////
////        s.moveToFirst();
////        // The ArrayList to save the information to return;
////        ArrayList<Bottle> bottleMade = new ArrayList<>();
////
////        while (!s.isAfterLast()) {
////
////            int bottleId = s.getInt(bottleIDIndex);
////            Timestamp dateF = Timestamp.valueOf(s.getString(dateFIndex));
////            String content = s.getString(contentIndex);
////            String usernameF = s.getString(usernameFIndex);
////
////            // The ArrayList to save the information to return;
////            Bottle bottle = new Bottle( usernameF, dateF ,content, bottleId);
////            bottleMade.add(bottle);
////            s.moveToNext();
////        }
////        s.close();
////        sqLiteDatabase.close();
////
////        return bottleMade;
////
////    }
//
//
//
//}
//
