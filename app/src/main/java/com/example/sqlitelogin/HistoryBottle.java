package com.example.sqlitelogin;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.sqlitelogin.service.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HistoryBottle extends AppCompatActivity {

        ListView listView;
        Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_history);

        }

        public void IMade(View view){
//            Intent read = new Intent(this, IMade().class);
//            startActivity(IMade);

            button = findViewById(R.id.imade);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UserService uService=new UserService(HistoryBottle.this);
                    final Commonvariables currentupser = (Commonvariables) getApplication();
                    String currentuser = currentupser.getB();
                    ArrayList<Readhistory> readhistories =  uService.getHistorymade(currentuser);
                    Readhistory r = null;
                    ArrayList<String> uf = new ArrayList<String>();
                    ArrayList<String> ur = new ArrayList<String>();
                    ArrayList<String> dt = new ArrayList<String>();
                    ArrayList<String> bi = new ArrayList<String>();

                    for (int i = 0; i<readhistories.size(); i++) {

                        r = readhistories.get(i);
                        uf.add(r.getUsernameF());
                        ur.add(r.getUsernameR());
                        dt.add(r.getTime());
                        bi.add(String.valueOf(r.getBottleID()));

                    }


                    ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
                    a.add(uf);
                    a.add(ur);
                    a.add(dt);
                    a.add(bi);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("arrayList", a);

                    Intent intent = new Intent(HistoryBottle.this,IMade.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });
        }


        public void IRead(View view){
//            Intent read = new Intent(this, IRead.class);
//            startActivity(read);

            button = findViewById(R.id.iread);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UserService uService=new UserService(HistoryBottle.this);
                    final Commonvariables currentupser = (Commonvariables) getApplication();
                    String currentuser = currentupser.getB();
                    ArrayList<Readhistory> readhistories =  uService.getHistory(currentuser);

                    Readhistory r = null;
                    ArrayList<String> uf = new ArrayList<String>();
                    ArrayList<String> ur = new ArrayList<String>();
                    ArrayList<String> dt = new ArrayList<String>();
                    ArrayList<String> bi = new ArrayList<String>();

                    for (int i = 0; i<readhistories.size(); i++) {

                        r = readhistories.get(i);
                        uf.add(r.getUsernameF());
                        ur.add(r.getUsernameR());
                        dt.add(r.getTime());
                        bi.add(String.valueOf(r.getBottleID()));

                    }


                    ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
                    a.add(uf);
                    a.add(ur);
                    a.add(dt);
                    a.add(bi);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("arrayList", a);

                    Intent intent = new Intent(HistoryBottle.this,IRead.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

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
