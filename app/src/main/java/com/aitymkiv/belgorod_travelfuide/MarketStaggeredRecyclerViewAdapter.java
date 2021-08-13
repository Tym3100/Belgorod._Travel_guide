package com.aitymkiv.belgorod_travelfuide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MarketStaggeredRecyclerViewAdapter extends RecyclerView.Adapter<MarketStaggeredRecyclerViewAdapter.ViewHolder> {

    private List<Product> mProductList;
    private Context mContext;

    public MarketStaggeredRecyclerViewAdapter(Context context, List<Product> productList) {
        this.mContext = context;
        this.mProductList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_market_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketStaggeredRecyclerViewAdapter.ViewHolder holder, int position) {
        Product product = mProductList.get(position);
        holder.imageView.setImageResource(product.getImageRes());
        holder.textViewProductName.setText(product.getName());
        holder.textViewProductPrice.setText(String.valueOf(product.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = product.getUri();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;
        final TextView textViewProductName, textViewProductPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageViewProduct);
            this.textViewProductName = itemView.findViewById(R.id.text_view_product_name);
            this.textViewProductPrice = itemView.findViewById(R.id.text_view_product_price);
        }
    }
}
