package com.sin.com.carpedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;
import android.content.Context;

public class carlist extends AppCompatActivity {
    private ListView listView;
    final Context context = this;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle2 = getIntent().getExtras();
        String value = bundle2.getString("value");
        setContentView(R.layout.activity_carlist);

        this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);


        databaseAccess.open();
        List<String> quotes = databaseAccess.getQuotes(value);
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        this.listView.setAdapter(adapter);
    }
}
