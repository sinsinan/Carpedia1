package com.sin.com.carpedia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        //String company = bundle.getString("company");
        //String price = bundle.getString("price");

        final Context context = this;
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);


        databaseAccess.open();
        final List<Integer> imageidl= databaseAccess.getQuoteimageid(name, context);


        final String[] data = databaseAccess.getQuotedata(name);

        databaseAccess.close();

        Integer[] imageid = new Integer[imageidl.size()];
        imageid = imageidl.toArray(imageid);

        TextView tv = (TextView)findViewById(R.id.textView2);
        TextView tv1 = (TextView)findViewById(R.id.textView);
        ImageView iv = (ImageView)findViewById(R.id.imageView);


        tv.setText(data[4]);
        tv1.setText(data[5]);
        iv.setImageResource(imageid[0]);



    }
}

