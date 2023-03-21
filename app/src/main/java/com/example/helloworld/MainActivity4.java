package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helloworld.model.Item;
import com.example.helloworld.myAdapter.ImageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    private List<Item> arrayStrings = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        listView = findViewById(R.id.viewList);
        addToArray();
        //adapter = new ArrayAdapter<>(this, R.layout.myrow, R.id.rowTextView, arrayStrings);
        imageAdapter = new ImageAdapter(arrayStrings, this);
        listView.setAdapter(imageAdapter);
        listView.setOnItemClickListener((parent, view, pos, id) -> {
            TextView tv = view.findViewById(R.id.rowTextView);
            System.out.println("You pressed" + tv.getText());
            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);
        });

    }

    public void addStrings(View view){
        arrayStrings.add(new Item("New Item", R.drawable.car3));
        imageAdapter.notifyDataSetChanged();
    }
    public void addToArray(){
        arrayStrings.add(new Item("Car 1", R.drawable.car1));
        arrayStrings.add(new Item("Car 2", R.drawable.car2));
    }
}