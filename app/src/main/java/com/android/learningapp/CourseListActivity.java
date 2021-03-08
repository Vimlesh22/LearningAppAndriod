package com.android.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.android.learningapp.adapters.AdapterCourseList;
import com.android.learningapp.models.Course_Model;

import java.util.ArrayList;
import java.util.List;

public class CourseListActivity extends AppCompatActivity {
    AdapterCourseList adapterCourseList;
    RecyclerView recyclerView;
    List<Course_Model> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Course List");


        initViews();

    }

    private void setData() {
        list.clear();
        list.add(new Course_Model(R.drawable.ic_content,"Course 1Course 1Course 1Course 1Course 1"));
        list.add(new Course_Model(R.drawable.ic_content,"Course 1Course 1Course 1Course 1Course 1"));
        list.add(new Course_Model(R.drawable.ic_content,"Course 1Course 1Course 1Course 1Course 1"));
        list.add(new Course_Model(R.drawable.ic_content,"Course 1Course 1Course 1Course 1Course 1"));
        list.add(new Course_Model(R.drawable.ic_content,"Course 2"));
        list.add(new Course_Model(R.drawable.ic_content,"Course 3"));
        list.add(new Course_Model(R.drawable.ic_content,"Course 4"));
        list.add(new Course_Model(R.drawable.ic_content,"Course 5"));
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        setData();
        adapterCourseList=new AdapterCourseList(this,list);
        recyclerView.setAdapter(adapterCourseList);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}