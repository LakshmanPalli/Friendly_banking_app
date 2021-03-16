 package com.example.bankapp;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AccHolders extends AppCompatActivity {

    private static final String TAG = "class AccHolders:";
    List<Model> modelListshowlist = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapterAccHolders adapter;
    String phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_accounts);

        Log.d(TAG, "onCreate: List of accounts create");

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        showData();
    }

    private void showData() {
        Log.d(TAG, "showData: called");
        modelListshowlist.clear();
        Log.d(TAG, "showData: modelList cleared");
        Cursor cursor = new DatabaseHouse(this).readAccountsTable();
        while(cursor.moveToNext()){

            Log.d(TAG, "showData: inside cursor");
            String balancefromdb = cursor.getString(2);
            Double balance = Double.parseDouble(balancefromdb);

            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setGroupingUsed(true);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            String price = nf.format(balance);

            Model model = new Model(cursor.getString(0), cursor.getString(1), price);
            modelListshowlist.add(model);
        }
        Log.d(TAG, "showData: outside cursor");

        adapter = new CustomAdapterAccHolders(AccHolders.this, modelListshowlist);
        mRecyclerView.setAdapter(adapter);

    }

    public void nextActivity(int position) {
        Log.d(TAG, "nextActivity: called");
        phonenumber = modelListshowlist.get(position).getPhoneno();
        Intent intent = new Intent(AccHolders.this, AccountInfo.class);
        intent.putExtra("phonenumber",phonenumber);
        startActivity(intent);
        Log.d(TAG, "close of nextActivity to AccountInfo");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_history){
            startActivity(new Intent(AccHolders.this, TransHistoryList.class));
        }
        return super.onOptionsItemSelected(item);
    }
}