package com.example.sqlitelogin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Timestamp;
import java.util.ArrayList;


public class DTBComment {
    SQLiteDatabase sqLiteDatabase;

    public void DTBBottle(SQLiteDatabase sqLiteDatabase) {

        this.sqLiteDatabase = sqLiteDatabase;
    }
    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS CommentDTB" +
                " (commentID INTEGER PRIMARY KEY, BottleID INTEGER, dateC DATETIME, genderC TEXT, comment TEXT, usernameC TEXT)");
    }


    public ArrayList<Comment> GetCommentByBottleID(int bottleID) {
        createTable();
        String q1 = "SELECT * FROM CommentDTB WHERE bottleID = this.bottleID";
        Cursor s = sqLiteDatabase.rawQuery(q1, null);

        int bottleIDIndex = s.getColumnIndex("bottleID");
        int commentIndex = s.getColumnIndex("comment");
        int dateCIndex = s.getColumnIndex("dateC");
        int genderCIndex = s.getColumnIndex("genderC");
        int commentIDIndex = s.getColumnIndex("commentID");
        int usernameCIndex = s.getColumnIndex("usernameC");

        s.moveToFirst();
        // The ArrayList to save the information to return;
        ArrayList<Comment> CommentInbottle = new ArrayList<>();

        while (!s.isAfterLast()) {

            int bottleId = s.getInt(bottleIDIndex);
            Timestamp dateC = Timestamp.valueOf(s.getString(dateCIndex));
            String genderC = s.getString(genderCIndex);
            int commentID = s.getInt(commentIDIndex);
            String comment = s.getString(commentIndex);
            String usernameC = s.getString(usernameCIndex);


            // The ArrayList to save the information to return;
            Comment comment1 = new Comment(bottleID, dateC,commentID, comment, genderC,usernameC);
            CommentInbottle.add(comment1);
            s.moveToNext();
        }
        s.close();
        sqLiteDatabase.close();

        return CommentInbottle;
    }

    public void addNewComment(int bottleID, String comment, String genderC, Timestamp dateC, String usernameC) {
        createTable();
        String sql = "INSERT INTO CommentDTB(bottleID, comment, genderC, dateC, usernameC) VALUES('%s','%s''%s''%s','%s')";
        sqLiteDatabase.execSQL(String.format(sql,
                bottleID, comment, genderC, dateC, usernameC));
    }

}

