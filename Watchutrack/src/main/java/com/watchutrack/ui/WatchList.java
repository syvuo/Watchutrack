package com.watchutrack.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.watchutrack.R;
import com.watchutrack.entity.Watch;
import com.watchutrack.timekeeping.AccuracyRating;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
public class WatchList extends ListActivity {

//    ArrayList<Watch> watchList = new ArrayList<Watch>();
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_main);
//
//        ListView watchListView = (ListView)findViewById(R.id.watchList);
//        FloatingActionButton plusButton = (FloatingActionButton) findViewById(R.id.addWatchButton);
//        //WATCH LIST
//        watchList.add(new Watch("Seiko", "Prospex", "SBBN031 Black Tuna", new AccuracyRating(0.5f, 0.5f)));
//        watchList.add(new Watch("Seiko", "Prospex", "SKX007", new AccuracyRating(25f,15f)));
//
//        ArrayAdapter<Watch> adapter = new ArrayAdapter<Watch>(this, android.R.layout.simple_list_item_1, watchList);
//
//        setListAdapter(adapter);
//    }

}
