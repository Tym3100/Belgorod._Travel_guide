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

import java.io.Serializable;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private final List<Category> mCategories;

    public CategoriesAdapter(List<Category> categories){
        this.mCategories = categories;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Category categoryCashback = mCategories.get(position);
        holder.imageViewCategory.setImageResource(categoryCashback.getImageResCategory());
        holder.textViewCategoryName.setText(categoryCashback.getCategoryName());
        holder.textViewCashBackValue.setText(String.valueOf(">" + categoryCashback.getCashbackValue() + "%"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<CashBack> cashBacks = categoryCashback.getCashBackList();
                Intent intent = new Intent(v.getContext(), CashbacksActivity.class);
                Bundle args = new Bundle();
                args.putSerializable(CashbacksActivity.KEY_CASHBACK_LIST, (Serializable) cashBacks);
                intent.putExtra(CashbacksActivity.KEY_BUNDLE, args);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageViewCategory;
        final TextView textViewCategoryName, textViewCashBackValue;
        public CategoriesViewHolder(@NonNull View itemView){
            super(itemView);
            imageViewCategory = itemView.findViewById(R.id.image_view_category);
            textViewCategoryName = itemView.findViewById(R.id.text_view_company_name);
            textViewCashBackValue = itemView.findViewById(R.id.text_view_cashback_value);

        }
    }
}
