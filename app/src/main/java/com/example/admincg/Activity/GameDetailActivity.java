package com.example.admincg.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admincg.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class GameDetailActivity extends AppCompatActivity {

    EditText match,id,date,prize,kill,fee,type,mode,map;
    Button submit;
    String timestamp;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mRef;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        match=findViewById(R.id.add_match_no);
        id=findViewById(R.id.add_id_pass);
        date=findViewById(R.id.add_date_time);
        prize=findViewById(R.id.add_prize);
        kill=findViewById(R.id.add_kill);
        fee=findViewById(R.id.add_entry_fee);
        type=findViewById(R.id.add_type);
        mode=findViewById(R.id.add_mode);
        map=findViewById(R.id.add_map);
        submit=findViewById(R.id.add_submit);
        Intent intent=getIntent();
        timestamp=intent.getStringExtra("time");


        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        firebaseDatabase= FirebaseDatabase.getInstance();
        mRef=firebaseDatabase.getReference("Match");

    //    final String uid=user.getUid();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                HashMap<String,Object> result=new HashMap<>();
                result.put("match_no",""+match.getText());
                result.put("id",""+id.getText());
                result.put("date",""+date.getText());
                result.put("prize",""+prize.getText());
                result.put("per_kill",""+kill.getText());
                result.put("entry",""+fee.getText());
                result.put("type",""+type.getText());
                result.put("mode",""+mode.getText());
                result.put("map",""+map.getText());

             //   result.put("uid",uid);
                mRef.child(timestamp).updateChildren(result);

                Toast.makeText(GameDetailActivity.this, "Updating...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(GameDetailActivity.this,MainActivity.class));
            }
        });

    }
}
