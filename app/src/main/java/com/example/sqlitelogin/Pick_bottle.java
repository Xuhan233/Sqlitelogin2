package com.example.sqlitelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitelogin.service.UserService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    EditText editText;
    Button comment;
    public TextView editTextComment;
    int a;

    public void pb(View view) {
       button =  findViewById(R.id.displayButton);
       textView = findViewById(R.id.bottleContent);
       editTextComment = findViewById(R.id.textViewComment);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 1;
                a =id;
                UserService uService=new UserService(Pick_bottle.this);
                Bottle bottle = uService.Pickbottle(id);
                String usermade = bottle.getUsernameF();
                String time = bottle.getDateF();
                String content = bottle.getContent();
                ArrayList<Comment> c = uService.getCommentbybottleID(id);
                StringBuffer stringBuffer = new StringBuffer();
                for (int i =0; i< c.size();i++) {
                    stringBuffer.append("\nComment" + i+1 + ": By user :" + c.get(i).getUsernameC());
                    stringBuffer.append("\n Commment at: " + c.get(i).getDateC());
                    stringBuffer.append("\n Comment with: " +c.get(i).getComment());

                }
                editTextComment.setText(stringBuffer);
                textView.setText("The Original conetent of the Bottle: \nMade by "+ usermade +"\nDate: " + time +"\nThe original content:" + content);
                final Commonvariables currentupser = (Commonvariables) getApplication();
                String uname = currentupser.getB();
                Readhistory readhistory = new Readhistory(uname,id,currentTime(),usermade);
                uService.historyRecord(readhistory);


            }
        });
    }
    public static long currentTimeLong()
    {
        return new Date().getTime();
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

    public void addComment(View view){
        editText = findViewById(R.id.editTextComment);
        comment = findViewById(R.id.buttonComment);

        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bottleid = a;
                String time = currentTime();
                String comment1 = editText.getText().toString().trim();
                final Commonvariables currentupser = (Commonvariables) getApplication();
                String uname = currentupser.getB();
                UserService uService=new UserService(Pick_bottle.this);
                Comment comment = new Comment(bottleid,time,comment1,uname);
                uService.addComment(comment);
                Toast.makeText(Pick_bottle.this, "Comment Successfully", Toast.LENGTH_LONG).show();
            }
        });
    }


}
