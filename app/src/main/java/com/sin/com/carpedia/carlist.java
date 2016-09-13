package com.sin.com.carpedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;
import android.content.Context;


import android.view.View;
import android.widget.AdapterView;

import android.widget.Toast;
import android.app.Activity;


import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.sin.com.carpedia.R;
import com.sin.com.carpedia.CustomList;
import com.sin.com.carpedia.RowItem;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;



public class carlist extends AppCompatActivity
         {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle2 = getIntent().getExtras();
        String[] name = bundle2.getStringArray("name");
        String[] company = bundle2.getStringArray("company");
        List<Integer> imageidl=bundle2.getIntegerArrayList("imageidl");
        setContentView(R.layout.activity_carlist);


        Integer[] imageid = new Integer[imageidl.size()];
        imageid = imageidl.toArray(imageid);

        ListView listView;
        List<RowItem> rowItems;

        /** Called when the activity is first created. */



            rowItems = new ArrayList<RowItem>();
            for (int i = 0; i < company.length; i++) {
                RowItem item = new RowItem(imageid[i], company[i], name[i]);
                rowItems.add(item);
            }

            listView = (ListView) findViewById(R.id.list);
            CustomList adapter = new CustomList(this,
                    R.layout.single_item, rowItems);
            listView.setAdapter(adapter);

        }



    }
