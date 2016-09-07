package com.sin.com.carpedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class filter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(filter.this, carlist.class);
        startActivity(intent);
    }
}