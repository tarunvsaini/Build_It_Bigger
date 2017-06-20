package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.tarun.androidjokelib.Jokes_Activity;


public class MainActivityFragment extends Fragment {


    ProgressBar progressBar;

    public MainActivityFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar= (ProgressBar) root.findViewById(R.id.progressBar);
        Button button= (Button) root.findViewById(R.id.jokeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                new EndpointsAsyncTask().execute(new jokeListener() {
                    @Override
                    public void OnJokeReceivedListener(String joke) {

                        startJokeActivity(joke);

                    }
                });

            }
        });


        return root;
    }

    private void startJokeActivity(String joke){
        progressBar.setVisibility(View.GONE);
        Intent mIntent = new Intent(getContext(),Jokes_Activity.class);
        mIntent.putExtra("JOKE",joke);
        startActivity(mIntent);
    }






}
