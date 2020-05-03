package com.example.sqlitelogin;

import java.sql.Timestamp;

public class Readhistory {
    private String usernameR;
    private int bottleID;
    private String time;
    private String usernameF;

    public Readhistory(String usernameR, int bottleID, String time, String usernameF) {
        this.usernameR = usernameR; //The username of user who read this bottle
        this.bottleID = bottleID; //Define the bottle
        this.time = time; //The time that the user read(Sort)
        this.usernameF = usernameF;
    }

    public String getUsernameR() {return usernameR;}

    public int getBottleID() {return bottleID;}

    public String getTime() {return time;}

    public String getUsernameF() {return usernameF;}
}