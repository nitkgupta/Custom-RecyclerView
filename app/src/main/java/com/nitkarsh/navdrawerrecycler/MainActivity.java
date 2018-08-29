package com.nitkarsh.navdrawerrecycler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.nitkarsh.adapter.AdapterData;
import com.nitkarsh.adapter.AllData;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    RecyclerView recyclerView;
    private List<Object> tagDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.recycler_view);
        fab=findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        AllData data=new AllData();
        tagDataList=data.getData();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        AdapterData myAdapter=new AdapterData(this,tagDataList,drawer,layoutManager);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Currently No Email Present.", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
