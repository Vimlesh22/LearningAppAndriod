package com.android.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.android.learningapp.adapters.AdapterTopicList;
import com.android.learningapp.models.Topic_Model;

import java.util.ArrayList;
import java.util.List;

public class TopicListActivity extends AppCompatActivity {
    AdapterTopicList adapterTopicList;
    List<Topic_Model> list=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Topic List");

        initViews();
        setData();
    }

    private void setData() {
        list.add(new Topic_Model("Topic 1 : Basic of Computer science"));
        list.add(new Topic_Model("Topic 2 : Basic of Network science"));
        list.add(new Topic_Model("Topic 3 : Advance object oriented programing concepts"));
        list.add(new Topic_Model("Topic 4 : Activity lifecycle "));
        adapterTopicList.notifyDataSetChanged();
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterTopicList=new AdapterTopicList(this,list);
        recyclerView.setAdapter(adapterTopicList);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}