package com.example.bankapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterHistory extends RecyclerView.Adapter<ViewHolder> {

    TransHistoryList HistoryList;
    List<Model> modelList;
    Context context;

    TextView mTranscstatus;

    public CustomAdapterHistory(TransHistoryList historyList, List<Model> modelList) {
        this.HistoryList = historyList;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transfer_history_list, parent, false);

        mTranscstatus = itemView.findViewById(R.id.transactionstatus);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName1.setText(modelList.get(position).getName1());
        holder.mName2.setText(modelList.get(position).getName2());
        holder.mBalance.setText(modelList.get(position).getBalance());
        holder.mDate.setText(modelList.get(position).getDate());
        holder.mTranscstatus.setText(modelList.get(position).getTransactionstatus());

        if(modelList.get(position).getTransactionstatus().equals("Failed")){
            holder.mTranscstatus.setTextColor(Color.parseColor("#f40404"));
        }else{
            holder.mTranscstatus.setTextColor(Color.parseColor("#4BB543"));
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}