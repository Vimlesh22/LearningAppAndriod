package com.android.learningapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learningapp.R;
import com.android.learningapp.TopicListActivity;
import com.android.learningapp.models.Course_Model;

import java.util.List;

public class AdapterCourseList extends RecyclerView.Adapter<AdapterCourseList.HolderCourse> {
    Context context;
    List<Course_Model> list;

    public AdapterCourseList(Context context, List<Course_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HolderCourse onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_course_list,parent,false);
        return new HolderCourse(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCourse holder, int position) {
        holder.setIsRecyclable(false);

        holder.txtCourse.setText(list.get(position).course_title);
        holder.img.setImageResource(list.get(position).course_img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, TopicListActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HolderCourse extends RecyclerView.ViewHolder {
        TextView txtCourse;
        ImageView img;
        public HolderCourse(@NonNull View itemView) {
            super(itemView);

            txtCourse=itemView.findViewById(R.id.txtCourse);
            img=itemView.findViewById(R.id.img);
        }
    }
}
