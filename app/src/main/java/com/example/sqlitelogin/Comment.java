package com.example.sqlitelogin;
import java.sql.Timestamp;

public class Comment {

    private int bottleID; //Define the bottle
    private String dateC; //When does the comment create

    private String comment; //context of the comment

    private String usernameC; //The username of the user who wrote this comment

    public Comment(int bottleID, String dateC, String comment, String usernameC) {
        this.bottleID = bottleID;
        this.dateC = dateC;
        this.comment = comment;
        this.usernameC = usernameC;
    }

    public int getBottleID(){return  bottleID;}

    public String getDateC(){return dateC;}


    public String getComment() {return comment;}


    public String getUsernameC() {return usernameC;}

}
