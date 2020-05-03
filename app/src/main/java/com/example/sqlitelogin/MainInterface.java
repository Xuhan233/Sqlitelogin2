package com.example.sqlitelogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.sqlitelogin.R;
import com.example.sqlitelogin.service.UserService;

import java.sql.Timestamp;

import java.util.ArrayList;

public class MainInterface extends AppCompatActivity {
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);
        final Commonvariables currentuser = (Commonvariables) getApplication();

        welcome = findViewById(R.id.welcome);


        welcome.setText("Hello "+ currentuser.getB());
    }

    public void pickBottle(View view){
//        int index = 0;

        Intent pick = new Intent (this, Pick_bottle.class);
//        ArrayList<Bottle> bottle = DTBBottle.Pickbottle(index);
//        Bottle bottleget = bottle.get(0);
//        Timestamp date = bottleget.getDateF();
//        String usernameF = bottleget.getUsernameF();
//        String genderF = bottleget.getGenderF();
//        String content = bottleget.getContent();


        startActivity(pick);

    }

    public void throwBottle(View view){
        Intent write = new Intent(this, Throw_bottle.class);
        startActivity(write);
    }

    public void historyBottle(View view){
        Intent history = new Intent(this, HistoryBottle.class);
        startActivity(history);
    }
}

