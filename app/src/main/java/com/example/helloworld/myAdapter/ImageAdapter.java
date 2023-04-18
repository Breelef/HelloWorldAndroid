package com.example.helloworld.myAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.model.Item;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private List<Item> items;
    private LayoutInflater inflater;

    public ImageAdapter(List<Item> items, Context context) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //inflate
        if(view == null){
            view = inflater.inflate(R.layout.myrow, null);
        }
        TextView textView = view.findViewById(R.id.rowTextView);
        textView.setText(items.get(i).getText());
        //ImageView imageView = view.findViewById(R.id.rowImageView);
        //imageView.setImageResource(items.get(i).getImage());
        return view;
    }
}
