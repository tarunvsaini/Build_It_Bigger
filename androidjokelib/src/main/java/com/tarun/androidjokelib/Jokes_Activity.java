package com.tarun.androidjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Jokes_Activity extends AppCompatActivity {


    public final static String JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        String joke = getIntent().getStringExtra(JOKE);
        TextView textViewJoke = (TextView) findViewById(R.id.javaJoke);
        textViewJoke.setText(joke);
    }
}
