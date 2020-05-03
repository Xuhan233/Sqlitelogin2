package com.example.sqlitelogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.sqlitelogin.service.UserService;

import java.util.ArrayList;

public class IMade extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imade);

        Intent intent = getIntent();
        Bundle buldle = intent.getExtras();
        ArrayList<ArrayList<String>> list =((ArrayList<ArrayList<String>>) buldle.getSerializable("arrayList"));
        ArrayList<String> display = new ArrayList<>();
        for(int i = 0; i<list.get(0).size();i++){

            display.add(String.format("ID:%s\ntime:%s\nusernameReceive:%s\nusernameSend:%s",list.get(0).get(i), list.get(1).get(i), list.get(2).get(i), list.get(3).get(i)));
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, display);
        ListView listView = findViewById(R.id.listMade);
        listView.setAdapter(adapter);
    }

}
