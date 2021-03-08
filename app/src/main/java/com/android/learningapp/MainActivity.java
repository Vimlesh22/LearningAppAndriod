package com.android.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.learningapp.adapters.AdapterHome;
import com.android.learningapp.models.HomeItem_Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterHome adapterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapterHome=new AdapterHome(this,getHomeMenu());
        recyclerView.setAdapter(adapterHome);
    }

    private List<HomeItem_Model> getHomeMenu() {
        List<HomeItem_Model> list=new ArrayList<>();
        list.add(new HomeItem_Model(R.drawable.ic_guide,"User Instructions"));
        list.add(new HomeItem_Model(R.drawable.ic_material,"Material"));
        list.add(new HomeItem_Model(R.drawable.ic_test,"Test"));
        list.add(new HomeItem_Model(R.drawable.ic_e_learning,"E-Learning"));
        return list;
    }
}