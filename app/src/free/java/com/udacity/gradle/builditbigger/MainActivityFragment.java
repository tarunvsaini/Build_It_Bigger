package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.tarun.androidjokelib.Jokes_Activity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {

    private InterstitialAd mInterstitialAd;
    ProgressBar progressBar;
    public MainActivityFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        progressBar= (ProgressBar) root.findViewById(R.id.progressBar);

        Button button= (Button) root.findViewById(R.id.jokeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else
                    {
                        Toast.makeText(getActivity(), "The interstitial wasn't loaded yet.", Toast.LENGTH_SHORT).show();
                    }


                    jokeLoad();


            }
        });


        return root;
    }

    private void jokeLoad()
    {
        new EndpointsAsyncTask().execute(new jokeListener() {
            @Override
            public void OnJokeReceivedListener(String joke) {

                startJokeActivity(joke);

            }
        });

    }

    private void startJokeActivity(String joke){
        progressBar.setVisibility(View.GONE);
        Intent mIntent = new Intent(getContext(),Jokes_Activity.class);
        mIntent.putExtra("JOKE",joke);
        startActivity(mIntent);
    }



}