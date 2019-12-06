package com.example.logincrud.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logincrud.ImageHelper;
import com.example.logincrud.R;
import com.example.logincrud.data.model.student.DataStudent;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<DataStudent> data;
    MainInterface.View view;

    public MainAdapter(Context context, List<DataStudent> data, MainInterface.View view) {
        this.context = context;
        this.data = data;
        this.view = view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_student,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNama.setText(data.get(position).getName());
        holder.tvNim.setText(data.get(position).getNim());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.onDelete(data.get(position).getNim());
            }

        });


        ImageHelper.getImage(holder.ivStudent,data.get(position).getImage().replace("https","http"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cvStudent)
        CardView cvStudent;
        @BindView(R.id.ivStudent)
        ImageView ivStudent;
        @BindView(R.id.tvNama)
        TextView tvNama;
        @BindView(R.id.tvNim)
        TextView tvNim;
        @BindView(R.id.btnDelete)
        Button btnDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
