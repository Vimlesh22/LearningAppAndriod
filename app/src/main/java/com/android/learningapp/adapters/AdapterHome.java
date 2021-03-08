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

import com.android.learningapp.CourseListActivity;
import com.android.learningapp.MaterialActivity;
import com.android.learningapp.R;
import com.android.learningapp.UserInstructionActivity;
import com.android.learningapp.models.HomeItem_Model;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.HolderHome> {
    Context context;
    List<HomeItem_Model> modelList;

    public AdapterHome(Context context, List<HomeItem_Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public HolderHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_home,parent,false);
        return new HolderHome(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderHome holder, int position) {
        holder.setIsRecyclable(false);
        holder.img.setImageResource(modelList.get(position).getImage());
        holder.txtMenu.setText(modelList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                if (position==0) {
                    intent = new Intent(context, UserInstructionActivity.class);
                }else if (position==1){
//                    intent=new Intent(context, MaterialActivity.class);
                    intent=new Intent(context, CourseListActivity.class);
                }

                if (intent!=null) {
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class HolderHome extends RecyclerView.ViewHolder {
        TextView txtMenu;
        ImageView img;
        public HolderHome(@NonNull View itemView) {
            super(itemView);
            txtMenu=itemView.findViewById(R.id.txtMenu);
            img=itemView.findViewById(R.id.img);
        }
    }
}
