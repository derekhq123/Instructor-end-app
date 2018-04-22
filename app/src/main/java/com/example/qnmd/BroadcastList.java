package com.example.qnmd;

/**
 * Created by Administrator on 7/2/2018.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BroadcastList extends Activity {

    private DatabaseReference mdatabase;

    Intent intent;
    private broadAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastlistlayout);
        intent=getIntent();
        String className=intent.getStringExtra("classname");
        mdatabase= FirebaseDatabase.getInstance().getReference().child(className).child("BroadcastQuestion");
        final ArrayList<ArrayList<String>> winnerList=new ArrayList<>();

        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    for(DataSnapshot data:dataSnapshot.child("0").child("Fastest").getChildren()){


                    String student=data.getKey().toString();
                    ArrayList<String> hahaha=new ArrayList<>();
                    hahaha.add(dataSnapshot.getKey().toString());
                    hahaha.add(student);
                    winnerList.add(hahaha);
                    }
                }
                adapter=new broadAdapter(winnerList,BroadcastList.this);
                ListView listView=(ListView)findViewById(R.id.broadlist);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {



            }

        });

    }

    class broadAdapter extends BaseAdapter{
        private ArrayList<ArrayList<String>> list=new ArrayList<>();
        private Context context;


        public broadAdapter(ArrayList<ArrayList<String>> input, Context context){
            list=input;
            this.context=context;
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        public View getView(final int position, View convertView, ViewGroup parent){
            View view=convertView;
            if(view==null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.broadcastlistview, null);
            }
            System.out.println(list);
            TextView textView1=(TextView)view.findViewById(R.id.quizz);
            textView1.setText("Quiz name: "+list.get(position).get(0));
            TextView textView2=(TextView)view.findViewById(R.id.stuname);
            textView2.setText("Winner student name: "+list.get(position).get(1));
            return view;
        }
    }


}