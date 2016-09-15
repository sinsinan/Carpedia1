package com.sin.com.carpedia;

import android.content.Context;
import android.content.Intent;
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
        String resource = bundle.getString("resource");
        int resourceInt = Integer.parseInt(resource);


        final Context context = this;
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);


        databaseAccess.open();
        //final List<Integer> imageidl= databaseAccess.getQuoteimageid(name, context);


        final String[] data = databaseAccess.getQuotedata(name);

        databaseAccess.close();

        // Integer[] imageid = new Integer[imageidl.size()];
        // imageid = imageidl.toArray(imageid);

        TextView nameContent = (TextView)findViewById(R.id.nameDetails);
        TextView company = (TextView)findViewById(R.id.companyDetails);
        ImageView iv = (ImageView)findViewById(R.id.imageView);
        TextView price = (TextView)findViewById(R.id.priceDetails);
        TextView type = (TextView)findViewById(R.id.typeInfo);
        TextView fuel = (TextView)findViewById(R.id.fuelDetails);
        TextView mileage = (TextView)findViewById(R.id.mileageDetails);
        TextView trans = (TextView)findViewById(R.id.transmissionDetails);
        TextView engine = (TextView)findViewById(R.id.engineDetails);
        TextView bhp = (TextView)findViewById(R.id.bhpDetails);
        TextView torque = (TextView)findViewById(R.id.torqueDetails);



        nameContent.setText(data[0]);
        company.setText(data[1]);
        price.setText("Rs."+" "+data[3]);
        iv.setImageResource(resourceInt);
        type.setText(data[2]);
        fuel.setText(data[4]);
        mileage.setText(data[6]+" "+"Kmpl");
        trans.setText(data[5]);
        engine.setText(data[7]+"cc");
        bhp.setText(data[8]);
        torque.setText(data[9]);



    }
}