package com.example.dell_i5.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StoryActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //firebase
        if(databaseReference==null) {

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference();
            databaseReference.keepSynced(true);
        }
        String keys=getIntent().getExtras().getString("keys");
        databaseReference.child(keys).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                        String sTitle= (String) dataSnapshot.child("storyTitle").getValue();
                        String sDesc=(String) dataSnapshot.child("storyDesc").getValue();
                        String sMoral=(String) dataSnapshot.child("storyMoral").getValue();

                TextView sT=findViewById(R.id.styTitle);
                TextView sD=findViewById(R.id.stydesc);
                TextView sM=findViewById(R.id.moral);

                sT.setText(sTitle);
                sD.setText(sDesc);
                sM.setText("Moral of Story -> "+sMoral);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(StoryActivity.this, "Problem with internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
