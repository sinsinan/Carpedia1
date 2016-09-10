package com.sin.com.carpedia;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {


    Button button01;
    Button button02;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        addListenerOnButton2();
    }

    public void addListenerOnButton() {

        final Context context = this;

        button01 = (Button) findViewById(R.id.button);

        button01.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, search.class);

                startActivity(intent);

            }

        });

    }

    public void addListenerOnButton2() {

        final Context context = this;

        button02 = (Button) findViewById(R.id.button2);

        button02.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, filter.class);
                startActivity(intent);

            }

        });

    }

}