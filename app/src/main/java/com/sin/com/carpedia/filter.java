package com.sin.com.carpedia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class filter extends AppCompatActivity {
Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.filter);
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        final Context context = this;

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                Intent i = new Intent(context, carlist.class);

        Spinner mySpinner = (Spinner) findViewById(R.id.Spinner);
        String types = mySpinner.getSelectedItem().toString();

               if(types.equals("None"))
                {
                    types="%";
                }


        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        String companys = mySpinner1.getSelectedItem().toString();

                if(companys.equals("None"))
                {
                    companys="%";
                }

        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);
        String prices = mySpinner2.getSelectedItem().toString();

                if(prices.equals("Below 4 Lakhs"))
                {
                    prices="between 0 and 400000";
                }
                else if (prices.equals("4 Lakhs - 9 Lakhs"))
                {
                    prices="between 400000 and 900000";
                }
                else if (prices.equals("10 Lakhs - 15 Lakhs"))
                {
                    prices="between 1000000 and 1500000";
                }
                else if (prices.equals("16 Lakhs - 20 Lakhs"))
                {
                    prices="between 1600000 and 2000000";
                }
                else if (prices.equals("Above 20 Lakhs"))
                {
                    prices="between 0 and 50000000";
                }
                else if (prices.equals("None"))
                {
                    prices="between 0 and 50000000";
                }
        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner3);
        String transmissions = mySpinner3.getSelectedItem().toString();

                if(transmissions.equals("None"))
                {
                    transmissions="%";
                }

        Spinner mySpinner4 = (Spinner) findViewById(R.id.spinner4);
        String fuels = mySpinner4.getSelectedItem().toString();

                if(fuels.equals("None"))
                {
                    fuels="%";
                }

                databaseAccess.open();
                final String[] name = databaseAccess.getQuotenamef(types,companys,prices,transmissions,fuels);
                final String[] company = databaseAccess.getQuotecompanyf(types,companys,prices,transmissions,fuels);
                final String[] price = databaseAccess.getQuotepricef(types,companys,prices,transmissions,fuels);
                final List<Integer> imageidl= databaseAccess.getQuoteimageidf(types,companys,prices,transmissions,fuels, context);
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