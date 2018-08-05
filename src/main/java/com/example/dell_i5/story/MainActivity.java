package com.example.dell_i5.story;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Story story;

    FirebaseListAdapter<Story> firebaseListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.list);



        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference();
        databaseReference.keepSynced(true);

//        for(int i=0;i<5;i++){
//            story=new Story("A cunning crow"+i,"look before you leap","once a dog found");
//            databaseReference.child(databaseReference.push().getKey()).setValue(story);
//        }

        firebaseListAdapter=new FirebaseListAdapter<Story>(MainActivity.this,Story.class,android.R.layout.two_line_list_item,databaseReference) {
            @Override
            protected void populateView(View v, Story model, final int position) {
                ((TextView) v.findViewById(android.R.id.text1)).setText(model.getStoryTitle());
                ((TextView) v.findViewById(android.R.id.text2)).setText("Moral of Story ->"+model.getStoryMoral());


                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                       DatabaseReference myRef=firebaseListAdapter.getRef(position);
                       String key=myRef.getKey().toString();

                        Intent intent=new Intent(MainActivity.this,StoryActivity.class);
                        intent.putExtra("keys",key);
                        startActivity(intent);
                       }
                });
            }
        };

        listView.setBackgroundColor(Color.WHITE);
        listView.setAdapter(firebaseListAdapter);


    }
}
