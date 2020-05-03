package com.example.sqlitelogin;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This file using to store the information we need for Bottle history
 * construct different variable type.
 *
 */

public class Bottle {
    private String usernameF; //The username of who create the bottle
    private String dateF; //The datebottle create
    private String content;// The original content of the bottle
    //private Integer bottleID;        // The key of the bottle
    private String usernameR;


    public Bottle(String usernameF, String dateF, String usernameR, String content) {
        this.usernameF = usernameF;
        this.content = content;
        this.dateF = dateF;
        this.usernameR = usernameR;

//        this.bottleID = bottleID;
    }



    public String getUsernameF() {
        return usernameF;
    }

    public String getDateF() {
        return dateF;
    }

    public String getContent() { return content; }

    public String getUsernameR() {return usernameR;}

//    public int getBottleID() { return bottleID; }


    public static String dateToStr(Timestamp time, String strFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(strFormat);
        String str = sf.format(time);
        return str;
    }
    public static Timestamp strToSqlDate(String strDate, String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        java.util.Date date = null;
        try {
            date = sf.parse(strDate);
        } catch ( ParseException e) {
            e.printStackTrace();
        }
        Timestamp dateSQL = new Timestamp(date.getTime());
        return dateSQL;
    }


}

