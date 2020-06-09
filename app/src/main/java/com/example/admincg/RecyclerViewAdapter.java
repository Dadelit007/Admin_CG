package com.example.admincg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    String match1,id1,date1,prize1,kill1,fee1,type1,mode1,map1;

    Context context;
    ArrayList<ModelMatch> matchList;
   private OnNoteList monNoteList;

    public RecyclerViewAdapter(Context context, ArrayList<ModelMatch> matchList, OnNoteList onNoteList) {
        this.context = context;
        this.matchList = matchList;
        this.monNoteList=onNoteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recycle_upcoming_frag,parent,false);
        return new ViewHolder(view,monNoteList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        match1=matchList.get(position).getMatch_no();
        id1=matchList.get(position).getId();
        date1=matchList.get(position).getDate();
        prize1=matchList.get(position).getPrize();
        kill1=matchList.get(position).getPer_kill();
        fee1=matchList.get(position).getEntry();
        type1=matchList.get(position).getType();
        mode1=matchList.get(position).getMode();
        map1=matchList.get(position).getMap();

        holder.match.setText(match1);
        holder.id.setText(id1);
        holder.date.setText(date1);
        holder.prize.setText(prize1);
        holder.kill.setText(kill1);
        holder.fee.setText(fee1);
        holder.type.setText(type1);
        holder.mode.setText(mode1);
        holder.map.setText(map1);


    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        TextView match,id,date,prize,kill,fee,type,mode,map,prog;
        OnNoteList onNoteList;
        public ViewHolder(@NonNull View itemView,OnNoteList onNoteList) {
            super(itemView);
            match=itemView.findViewById(R.id.match_no);
            id=itemView.findViewById(R.id.id_pass);
            date=itemView.findViewById(R.id.date_time);
            prize=itemView.findViewById(R.id.prize);
            kill=itemView.findViewById(R.id.kill);
            fee=itemView.findViewById(R.id.entry_fee);
            type=itemView.findViewById(R.id.type);
            mode=itemView.findViewById(R.id.mode);
            map=itemView.findViewById(R.id.map);
            cardView=itemView.findViewById(R.id.upcoming_card);
            this.onNoteList=onNoteList;
            itemView.setOnClickListener(this);
           // prog=itemView.findViewById(R.id.progress);
        }

        @Override
        public void onClick(View view) {

            onNoteList.onNote(getAdapterPosition());
        }
    }

    public interface OnNoteList{
        void onNote(int position);
    }
}
