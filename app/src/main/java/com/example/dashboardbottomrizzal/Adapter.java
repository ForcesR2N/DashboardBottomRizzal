package com.example.dashboardbottomrizzal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.HolderData> {

    List<Item> listData;
    LayoutInflater inflater;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener listener;

    // Add a setter for the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Adapter(Context context, List<Item> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Adapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.HolderData holder, int position) {
        Item item = listData.get(position);
        holder.textShape.setText(item.getShape());

        Glide.with(holder.itemView.getContext())
                .load(item.getImage())
                .into(holder.imageView);


        holder.imageView.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        TextView textShape;
        ImageView imageView;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            textShape = itemView.findViewById(R.id.shapeView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
