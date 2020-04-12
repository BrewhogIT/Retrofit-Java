package com.brewhog.android.retrofit_java.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brewhog.android.retrofit_java.pojo.Anekdot;
import com.brewhog.android.retrofit_java.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnekdotAdapter extends RecyclerView.Adapter<AnekdotHolder> {
    private ArrayList<Anekdot> mAnekdots;

    public AnekdotAdapter(ArrayList<Anekdot> anekdots) {
        mAnekdots = anekdots;
    }

    public void setAnekdots(ArrayList<Anekdot> anekdots) {
        mAnekdots = anekdots;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnekdotHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.anekdot_item,parent,false);
        return new AnekdotHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnekdotHolder holder, int position) {
        holder.bind(mAnekdots.get(position));
    }

    @Override
    public int getItemCount() {
        return mAnekdots.size();
    }
}
