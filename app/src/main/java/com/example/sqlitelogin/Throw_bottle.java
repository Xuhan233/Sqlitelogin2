package com.example.sqlitelogin;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sqlitelogin.service.UserService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Throw_bottle extends AppCompatActivity {


    EditText message;
    Button button;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    public Button throwBottle;
    AnimationDrawable throwAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw_bottle);
        message = findViewById(R.id.context);
        button = findViewById(R.id.throwButton);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setBackgroundResource(R.drawable.animation);
        throwAnimation = (AnimationDrawable) imageView.getBackground();
    }

    public void sendItFlowing(View view){
        throwBottle = findViewById(R.id.throwButton);

        throwBottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Commonvariables currentupser = (Commonvariables) getApplication();
                String uname = currentupser.getB();
                String usernameR = null;
                String time = currentTime();
                String content = message.getText().toString().trim();
                UserService uService=new UserService(Throw_bottle.this);
                Bottle bottle = new Bottle(uname,time,usernameR,content);
                uService.throwBottle(bottle);
                throwAnimation.start();
                Toast.makeText(Throw_bottle.this, "Throw Successfully", Toast.LENGTH_LONG).show();



            }
        });



    }
    public String currentTime()
    {
        Date date = new Date();
        return toString(date);
    }
    public static String toString(Date date)
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


}
