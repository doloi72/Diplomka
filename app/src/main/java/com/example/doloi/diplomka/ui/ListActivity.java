package com.example.doloi.diplomka.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.doloi.diplomka.R;
import com.example.doloi.diplomka.adapter.DerpAdapter;
import com.example.doloi.diplomka.model.DerpData;
import com.example.doloi.diplomka.model.ListItem;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements DerpAdapter.ItemClickCallback<ListItem> {

    private RecyclerView recView;
    private DerpAdapter adapter;
    private ArrayList listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listData = (ArrayList) DerpData.getListData();

        recView = (RecyclerView)findViewById(R.id.rec_list);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DerpAdapter(listData, this, this);
        recView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onItemClick(ListItem item) {
        Intent i = DetailActivity.newInstance(this, item.getTitle(), item.getSubTitle());
        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(ListItem item, int position) {
        if (item.isCheck()){
            item.setCheck(false);
        }else {
            item.setCheck(true);
        }

        adapter.notifyItemChanged(position);
    }
}
