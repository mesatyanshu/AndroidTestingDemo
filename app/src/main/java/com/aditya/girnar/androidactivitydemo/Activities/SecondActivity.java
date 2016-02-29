package com.aditya.girnar.androidactivitydemo.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.girnar.androidactivitydemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aditya on 1/15/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getCanonicalName();
    private RecyclerView mRecyclerView;
    private List<String> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //resetting notification count
        FirstActivity.count = 1;
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add("Element at position " + i);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerListAdapter(list));
    }

    private class PersonalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTextView;
        TextView ageTextView;
        TextView carTextView;

        public PersonalViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameTextView = (TextView) itemView.findViewById(R.id.textView1);
            ageTextView = (TextView) itemView.findViewById(R.id.textView2);
            carTextView = (TextView) itemView.findViewById(R.id.textView3);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(SecondActivity.this, "Item " + getAdapterPosition() + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }


    private class RecyclerListAdapter extends RecyclerView.Adapter<PersonalViewHolder> {

        List<String> list = null;

        public RecyclerListAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public PersonalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            PersonalViewHolder personalViewHolder = new PersonalViewHolder(itemView);
            return personalViewHolder;
        }

        @Override
        public void onBindViewHolder(PersonalViewHolder holder, int position) {
            holder.nameTextView.setText("Name : Person" + position);
            holder.ageTextView.setText("Age : " + (position + 16));
            holder.carTextView.setText("Car Owned : Volkswagen Polo");
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
