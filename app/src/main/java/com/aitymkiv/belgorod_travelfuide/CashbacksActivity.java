package com.aitymkiv.belgorod_travelfuide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//
public class CashbacksActivity extends AppCompatActivity {
    public static final String KEY_CASHBACK_LIST = "KEY_CASHBACK_LIST";
    public static final String KEY_BUNDLE = "KEY_BUNDLE";
    private RecyclerView recyclerView;
    private List<CashBack> cashBacksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashbacks);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra(KEY_BUNDLE);

        cashBacksList = (List<CashBack>) args.getSerializable(KEY_CASHBACK_LIST);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_cashback);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        CashbackAdapter cashbackAdapter = new CashbackAdapter(cashBacksList);
        recyclerView.setAdapter(cashbackAdapter);
    }
}