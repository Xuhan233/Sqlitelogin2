package com.example.sqlitelogin;

import android.app.Application;

public class Commonvariables extends Application {

    private String b;

    public String getB(){
        return this.b;
    }


    public void setB(String c){
        this.b= c;
    }
    @Override
    public void onCreate(){
        super.onCreate();
    }


}

