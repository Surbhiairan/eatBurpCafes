package com.example.aniruddh.eatburp1;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.aniruddh.eatburp1.SearchListItems;
import com.example.aniruddh.eatburp1.ListViewAdapter;
import com.example.aniruddh.eatburp1.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] searchListItemsList;
    ArrayList<SearchListItems> arraylist = new ArrayList<SearchListItems>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Generate sample data

        searchListItemsList = new String[]{"Pizza", "Cake", "Biryani",
                 "Drinks", "Thuppa", "Momos", "Desserts"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < searchListItemsList.length; i++) {
            SearchListItems itemNames = new SearchListItems(searchListItemsList[i]);
            // Binds all strings into an array
            arraylist.add(itemNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
