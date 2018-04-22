package com.example.qnmd;

/**
 * Created by Administrator on 7/2/2018.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Thread.sleep;

public class LecturerRating extends Activity {

    private DatabaseReference mdatabase;
    private Button button;
    private Intent intent;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private String InstructorName="sudipta";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture);
        intent=getIntent();
        String className=intent.getStringExtra("classname");

        mdatabase= FirebaseDatabase.getInstance().getReference().child(className);
        textView1=(TextView)findViewById(R.id.Iname);
        textView2=(TextView)findViewById(R.id.clarityRating);
        textView3=(TextView)findViewById(R.id.MeaningfulRating);
        textView4=(TextView)findViewById(R.id.RelavantRating);
        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dsp:dataSnapshot.getChildren()){

                    if(dsp.getKey().equals("Lecturer")){
                        System.out.println("1");
                        InstructorName=dsp.getValue().toString();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DatabaseReference newmdatabase=mdatabase.child("Rating").child("0").child(InstructorName);
        textView1.setText(InstructorName);
        newmdatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dsp:dataSnapshot.getChildren()){

                    if(dsp.getKey().toString().equals("Clarity")){
                        textView2.setText(dsp.getValue().toString());
                    }else if(dsp.getKey().toString().equals("Meaningful")){
                        textView3.setText(dsp.getValue().toString());
                    }else if(dsp.getKey().toString().equals("Relevant")){
                        textView4.setText(dsp.getValue().toString());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    /**
     * 初始化各种控件
     */



}