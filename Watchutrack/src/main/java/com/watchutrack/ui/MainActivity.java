package com.watchutrack.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.watchutrack.R;
import com.watchutrack.entity.Watch;
import com.watchutrack.timekeeping.AccuracyRating;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static final int ADD_WATCH_REQUEST_CODE = 1;

    ArrayList<Watch> watchList = new ArrayList<Watch>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //UI ELEMENTS
        ListView watchListView = (ListView) findViewById(R.id.watchList);
        FloatingActionButton plusButton = (FloatingActionButton) findViewById(R.id.addWatchButton);
        //View addNewWatch = findViewById(R.layout.new_watch_form);

        //WATCH LIST
        watchList.add(
                new Watch()
                        .withCompany("Seiko")
                        .withSeries("Prospex")
                        .withModel("SBBN031 Black tuna")
                        .withAccuracyRating(new AccuracyRating(0.5f, 0.5f))
        );
        watchList.add(
                new Watch()
                        .withCompany("Seiko")
                        .withSeries("Prospex")
                        .withModel("SKX007")
                        .withAccuracyRating(new AccuracyRating(25f, 15f))
        );
        final ArrayAdapter<Watch> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, watchList);
        watchListView.setAdapter(adapter);

        //ADD WATCH BUTTON
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addWatch = new Intent(MainActivity.this, AddWatchActivity.class);
                startActivityForResult(addWatch, ADD_WATCH_REQUEST_CODE);
                adapter.notifyDataSetChanged();
//                watchList.add(new Watch("Seiko", "Prospex", "SKX007", new AccuracyRating(25f,15f)));
//                adapter.notifyDataSetChanged();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int pRequestCode, int pResultCode, Intent pData) {

        if (pRequestCode == ADD_WATCH_REQUEST_CODE) {
            if(pResultCode == Activity.RESULT_OK){
                watchList.add((Watch) pData.getParcelableExtra("watch"));
                //adapter.notifyDataSetChanged();
            }
            if (pResultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
