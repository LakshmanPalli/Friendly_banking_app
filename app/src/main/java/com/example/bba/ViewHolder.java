package com.example.bba;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView mName, mPhonenumber, mBalance, mRupee, mRupeeslash, mName1, mName2, mDate, mTransc_status;
    ImageView mPhone, mArrow;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        mName = itemView.findViewById(R.id.username);
        mPhonenumber = itemView.findViewById(R.id.userphonenumber);
        mBalance = itemView.findViewById(R.id.balance);
        mRupee = itemView.findViewById(R.id.rupee);
        mRupeeslash = itemView.findViewById(R.id.rupeeslash);
        mPhone = itemView.findViewById(R.id.phone);
        mName1 = itemView.findViewById(R.id.name1);
        mName2 = itemView.findViewById(R.id.name2);
        mDate = itemView.findViewById(R.id.date);
        mArrow = itemView.findViewById(R.id.arrow);
        mTransc_status = itemView.findViewById(R.id.transaction_status);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

    }
    private ViewHolder.ClickListener mClickListener;
    public interface  ClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
