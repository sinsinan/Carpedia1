package com.sin.com.carpedia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    ImageButton button01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        addListenerOnButton();
    }

    public void addListenerOnButton()
        {
            final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        final Context context = this;


        button01 = (ImageButton) findViewById(R.id.imageButton);

        button01.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(context, carlist.class);
                EditText textView = (EditText) findViewById(R.id.EditText1);
                String value0 = textView.getText().toString();
                String value=("%"+value0+"%");



                databaseAccess.open();
                final String[] name = databaseAccess.getQuotename(value);
                final String[] company = databaseAccess.getQuotecompany(value);
                final String[] price = databaseAccess.getQuoteprice(value);
                final List<Integer> imageidl= databaseAccess.getQuoteimageid(value, context);
                databaseAccess.close();

                Bundle bundle = new Bundle();
                bundle.putStringArray("name",name);
                bundle.putStringArray("company",company);
                bundle.putStringArray("price",price);
                bundle.putIntegerArrayList("imageidl", (ArrayList<Integer>) imageidl);
                i.putExtras(bundle);
                startActivity(i);

            }

        });

    }




    }


