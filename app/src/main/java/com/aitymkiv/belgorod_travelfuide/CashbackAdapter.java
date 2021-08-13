package com.aitymkiv.belgorod_travelfuide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class  CashbackAdapter extends RecyclerView.Adapter<CashbackAdapter.CashbackViewHolder> {

    private final List<CashBack> mCashBacks;

    public CashbackAdapter(List<CashBack> cashBacks){
        this.mCashBacks = cashBacks;
    }

    @NonNull
    @Override
    public CashbackAdapter.CashbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cashback_item, parent, false);
        return new CashbackAdapter.CashbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CashbackAdapter.CashbackViewHolder holder, int position) {
        CashBack cashBack = mCashBacks.get(position); 
        holder.imageViewCompany.setImageResource(cashBack.getImageRes());
        holder.textViewReceivingConditionCashBack.setText("Условия получения кэшбэка\n" +
                "Примерный срок начисления: " + cashBack.getDaysToCashBack() + " д.");
        holder.textViewCashBackValue.setText(String.valueOf(cashBack.getCashBack()) + "%");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCashBacks.size();
    }

    public static class CashbackViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageViewCompany;
        final TextView textViewReceivingConditionCashBack, textViewCashBackValue;
        public CashbackViewHolder(@NonNull View itemView){
            super(itemView);
            imageViewCompany = itemView.findViewById(R.id.image_view_company);
            textViewReceivingConditionCashBack = itemView.findViewById(R.id.text_view_conditional);
            textViewCashBackValue = itemView.findViewById(R.id.text_view_cashback_value);

        }
    }
}