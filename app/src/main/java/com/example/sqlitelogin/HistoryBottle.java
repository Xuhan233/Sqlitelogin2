package com.example.sqlitelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HistoryBottle extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_history);
        }

        public void IMade(View view){
            Intent made = new Intent(this, IMade.class);
            startActivity(made);
        }

        public void IRead(View view){
            Intent read = new Intent(this, IRead.class);
            startActivity(read);
        }
    }
