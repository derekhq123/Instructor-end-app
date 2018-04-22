package com.example.qnmd;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends Activity {

    Button b1,b2,b3,b4,b5,b6;

    private DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
        final Context context = this;
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();

                databaseReference.child(b1.getText().toString()).child("Lecturer").setValue(intent.getStringExtra("Instructor"));
                intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("class name",b1.getText().toString());

                startActivity(intent);


            }}
        );
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();

                databaseReference.child(b2.getText().toString()).child("Lecturer").setValue(intent.getStringExtra("Instructor"));
                intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("class name",b2.getText().toString());

                startActivity(intent);


            }}
        );
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();

                databaseReference.child(b3.getText().toString()).child("Lecturer").setValue(intent.getStringExtra("Instructor"));
                intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("class name",b3.getText().toString());

                startActivity(intent);

            }}
        );
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();

                databaseReference.child(b4.getText().toString()).child("Lecturer").setValue(intent.getStringExtra("Instructor"));
                intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("class name",b4.getText().toString());

                startActivity(intent);


            }}
        );
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();

                databaseReference.child(b5.getText().toString()).child("Lecturer").setValue(intent.getStringExtra("Instructor"));
                intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("class name",b5.getText().toString());

                startActivity(intent);

            }}
        );
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();

                databaseReference.child(b6.getText().toString()).child("Lecturer").setValue(intent.getStringExtra("Instructor"));
                intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("class name",b6.getText().toString());

                startActivity(intent);

            }}
        );
    }

}