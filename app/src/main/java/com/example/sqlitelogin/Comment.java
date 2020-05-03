package com.example.sqlitelogin;
import java.sql.Timestamp;

public class Comment {

    private int bottleID; //Define the bottle
    private String dateC; //When does the comment create
    private int commentID; //Define comment(key)
    private String comment; //context of the comment
    private String genderC; //The gender of the user who wrote this comment
    private String usernameC; //The username of the user who wrote this comment

    public Comment(int bottleID, String dateC, int commentID, String comment, String genderC, String usernameC) {
        this.bottleID = bottleID;
        this.dateC = dateC;
        this.commentID = commentID;
        this.comment = comment;
        this.genderC = genderC;
        this.usernameC = usernameC;
    }

    public int getBottleID(){return  bottleID;}

    public String getDateC(){return dateC;}

    public int getCommentID(){return commentID;}

    public String getComment() {return comment;}

    public String getGenderC() {return genderC;}

    public String getUsernameC() {return usernameC;}

}
