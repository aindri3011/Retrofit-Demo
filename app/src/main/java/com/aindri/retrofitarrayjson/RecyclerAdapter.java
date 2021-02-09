package com.aindri.retrofitarrayjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    MyViewHolder myViewHolder;
    Context context;
    ArrayList<Model>arrayList;

    public RecyclerAdapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.data_item,parent,false);
        myViewHolder=new MyViewHolder(view);

        return myViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_name.setText(arrayList.get(position).getName());
        holder.txt_id.setText(arrayList.get(position).getId());
        holder.txt_category.setText(arrayList.get(position).getCategory());
        holder.txt_categoryId.setText(arrayList.get(position).getCategoryid());
        holder.txt_address.setText(arrayList.get(position).getAddress());
        holder.txt_employeecode.setText(arrayList.get(position).getEmpcode());
        holder.txt_contact.setText(arrayList.get(position).getContact());
        holder.txt_descrip.setText(arrayList.get(position).getDescription());

        Glide.with(context).load(arrayList.get(position).getImage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name,txt_id,txt_category,txt_categoryId,txt_address,txt_employeecode,txt_contact,txt_descrip;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name=itemView.findViewById(R.id.txt_name);
            txt_id=itemView.findViewById(R.id.txt_id);
            txt_category=itemView.findViewById(R.id.txt_category);
            txt_categoryId=itemView.findViewById(R.id.txt_categoryId);
            txt_address=itemView.findViewById(R.id.txt_address);
            txt_employeecode=itemView.findViewById(R.id.txt_employeecode);
            txt_contact=itemView.findViewById(R.id.txt_contact);
            txt_descrip=itemView.findViewById(R.id.txt_descrip);
            img=itemView.findViewById(R.id.img);

        }
    }
}
