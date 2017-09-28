package com.example.aniruddh.eatburp1;

/**
 * Created by hp on 9/27/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<SearchListItems> searchListItemsList = null;
    private ArrayList<SearchListItems> arraylist;

    public ListViewAdapter(Context context, List<SearchListItems> searchListItemsList) {
        mContext = context;
        this.searchListItemsList = searchListItemsList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<SearchListItems>();
        this.arraylist.addAll(searchListItemsList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return searchListItemsList.size();
    }

    @Override
    public SearchListItems getItem(int position) {
        return searchListItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(searchListItemsList.get(position).getSearchItemName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        searchListItemsList.clear();
        if (charText.length() == 0) {
            searchListItemsList.addAll(arraylist);
        } else {
            for (SearchListItems wp : arraylist) {
                if (wp.getSearchItemName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    searchListItemsList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}