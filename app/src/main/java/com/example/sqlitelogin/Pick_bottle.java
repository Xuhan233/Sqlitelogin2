package com.example.sqlitelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sqlitelogin.service.UserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Pick_bottle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_bottle);
    }
    public TextView textView;
    public Button button;

    public void pb(View view) {
       button =  findViewById(R.id.displayButton);
       textView = findViewById(R.id.bottleContent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserService uService=new UserService(Pick_bottle.this);
                Bottle bottle = uService.Pickbottle(1);
                String usermade = bottle.getUsernameF();
                String time = bottle.getDateF();
                String content = bottle.getContent();
                System.out.println("1111");
                System.out.println(usermade);
                textView.setText("username: "+ usermade +"\ntime" + time +"\ncontent" + content);
            }
        });
    }
    public static long currentTimeLong()
    {
        return new Date().getTime();
    }

}
