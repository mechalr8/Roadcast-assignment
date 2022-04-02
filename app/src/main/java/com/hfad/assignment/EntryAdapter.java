package com.hfad.assignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.assignment.jsonData.Entry;

import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryViewHolder> {
    List<Entry> entry;
    Context context;

    public EntryAdapter(Context context, List<Entry> entries){
        this.context = context;
        entry = entries;
    }

    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new EntryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {
        holder.api.setText(entry.get(position).toString());
        holder.description.setText(entry.get(position).toString());
        holder.auth.setText(entry.get(position).toString());
        holder.https.setText(entry.get(position).toString());
        holder.cors.setText(entry.get(position).toString());
        holder.link.setText(entry.get(position).toString());
        holder.category.setText(entry.get(position).toString());
    }

    @Override
    public int getItemCount() {
        int size = 0;
        try {
            size = entry.size();
        }catch (Exception e){
            Log.e("Error", e.toString());
        }
        return size;
    }


    public class EntryViewHolder extends RecyclerView.ViewHolder{
        private TextView api;
        private TextView description;
        private TextView auth;
        private TextView https;
        private TextView cors;
        private TextView link;
        private TextView category;
        public EntryViewHolder(@NonNull View itemView) {
            super(itemView);
            api = itemView.findViewById(R.id.api);
            description = itemView.findViewById(R.id.description);
            auth = itemView.findViewById(R.id.auth);
            https = itemView.findViewById(R.id.https);
            cors = itemView.findViewById(R.id.cors);
            link = itemView.findViewById(R.id.link);
            category = itemView.findViewById(R.id.category);
        }
    }
}
