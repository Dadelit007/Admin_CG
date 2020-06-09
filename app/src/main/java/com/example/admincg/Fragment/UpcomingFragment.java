package com.example.admincg.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admincg.Activity.GameDetailActivity;
import com.example.admincg.ModelMatch;
import com.example.admincg.R;
import com.example.admincg.RecyclerViewAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class UpcomingFragment extends Fragment implements RecyclerViewAdapter.OnNoteList {

    Button add;
    FirebaseAuth firebaseAuth,mAuth;
    FirebaseUser user,muser;
    FirebaseDatabase firebaseDatabase,database;
    DatabaseReference mRef;

    ArrayList<ModelMatch> matchList;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.upcoming_fragment,container,false);


        recyclerView=view.findViewById(R.id.recycle_upcoming);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        //  linearLayoutManager.setStackFromEnd(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        firebaseDatabase= FirebaseDatabase.getInstance();
        mRef=firebaseDatabase.getReference("Match");



        matchList=new ArrayList<>();



        Query query=mRef.orderByChild("uid");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())

                {
                    ModelMatch chat=ds.getValue(ModelMatch.class);
                    matchList.add(chat);
                    recyclerViewAdapter=new RecyclerViewAdapter(getActivity(),matchList,getActivity());
                    recyclerViewAdapter.notifyDataSetChanged();

                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        add=view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth=FirebaseAuth.getInstance();
                muser=mAuth.getCurrentUser();
                database=FirebaseDatabase.getInstance();
                String timestamp=String.valueOf(System.currentTimeMillis());
                String uid=muser.getUid();

                //   DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();

                HashMap<String,Object> hashMap1= new HashMap<>();
                hashMap1.put("image","");
                hashMap1.put("match_no","0");
                hashMap1.put("type","");
                hashMap1.put("id","");
                hashMap1.put("pass","");
                hashMap1.put("date","09/06/2020");
                hashMap1.put("time","");
                hashMap1.put("prize","1000");
                hashMap1.put("per_kill","20");
                hashMap1.put("entry","50");
                hashMap1.put("mode","Tpp");
                hashMap1.put("live",false);
                hashMap1.put("is_full","");
                hashMap1.put("timestamp",timestamp);
                hashMap1.put("map","ERANGEL");
                hashMap1.put("uid",uid);


                //    databaseReference.child("Match").push().setValue(hashMap1);
                DatabaseReference reference1=database.getReference("Match");
                reference1.child(timestamp).setValue(hashMap1);
                //  Toast.makeText(AddGamesActivity.this, "Game Added...", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getActivity(), GameDetailActivity.class);
                intent.putExtra("time",timestamp);
                startActivity(intent);
               // startActivity(new Intent(getActivity(), AddGamesActivity.class));
            }
        });

        return view;
    }

    private void fire() {

    }


    @Override
    public void onNote(int position) {

    }
}
