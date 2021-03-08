package com.android.learningapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learningapp.MaterialActivity;
import com.android.learningapp.R;
import com.android.learningapp.models.Topic_Model;

import java.util.List;

public class AdapterTopicList extends RecyclerView.Adapter<AdapterTopicList.HolderTopic> {
    Context context;
    List<Topic_Model> list;

    public AdapterTopicList(Context context, List<Topic_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HolderTopic onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_topic_list,parent,false);
        return new HolderTopic(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderTopic holder, int position) {
        holder.setIsRecyclable(false);
        holder.txtTopic.setText(list.get(position).getTopic_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MaterialActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HolderTopic extends RecyclerView.ViewHolder {
        TextView txtTopic;

        public HolderTopic(@NonNull View itemView) {
            super(itemView);

            txtTopic=itemView.findViewById(R.id.txtTopic);
        }
    }
}
