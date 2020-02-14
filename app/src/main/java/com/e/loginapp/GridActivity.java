package com.e.loginapp;

import android.os.Bundle;
import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;


public class GridActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        mRecyclerView = findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(false, false, getApps());

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2,
                LinearLayoutManager.VERTICAL, true));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        new GravitySnapHelper(Gravity.TOP).attachToRecyclerView(mRecyclerView);
    }

    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("Google+", R.drawable.img1, 4.6f));
        apps.add(new App("Gmail", R.drawable.img2, 4.8f));
        apps.add(new App("Inbox", R.drawable.img3, 4.5f));
        return apps;
    }
}
