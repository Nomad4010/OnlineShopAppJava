package com.example.onlineshopappjava.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.bumptech.glide.Glide;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.onlineshopappjava.Activity.Activity.DetailActivity;
import com.example.onlineshopappjava.Activity.Domain.PopularDomain;
import com.example.onlineshopappjava.R;

import java.util.ArrayList;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.ViewHolder> {
    private ArrayList<PopularDomain> items;
    private Context context;

    public PopularListAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopularDomain item = items.get(position);
        holder.titleTxt.setText(item.getTitle());
        holder.feeTxt.setText("₸" + item.getPrice());
        holder.ScoreTxt.setText(String.valueOf(item.getScore()));

        int drawableResourceId = holder.itemView.getResources().getIdentifier(item.getPicUrl(),
                "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object",items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTxt;
        public TextView feeTxt;
        public TextView ScoreTxt;
        public ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            feeTxt = itemView.findViewById(R.id.feeTxt);
            ScoreTxt = itemView.findViewById(R.id.scoreTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}