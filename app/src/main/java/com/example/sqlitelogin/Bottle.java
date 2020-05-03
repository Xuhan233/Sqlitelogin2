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
    private Timestamp dateF; //The datebottle create
    private String genderF;           // The usernameF's gender
    private String content;           // The original content of the bottle
    private Integer bottleID;        // The key of the bottle


    public Bottle(String usernameF, Timestamp dateF, String genderF, String content,
                  int bottleID) {
        this.usernameF = usernameF;
        this.content = content;
        this.dateF = dateF;
        this.genderF = genderF;
        this.bottleID = bottleID;
    }



    public String getUsernameF() {
        return usernameF;
    }

    public Timestamp getDateF() {
        return dateF;
    }

    public String getGenderF() {
        return genderF;
    }

    public String getContent() { return content; }

    public int getBottleID() { return bottleID; }


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

