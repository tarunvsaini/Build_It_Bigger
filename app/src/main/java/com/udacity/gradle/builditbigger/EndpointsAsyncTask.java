package com.udacity.gradle.builditbigger;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.tarun.myapplication.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<jokeListener, Void, String> {
    private static MyApi myApiService = null;
    private jokeListener mJokeListener;

    @Override
    protected String doInBackground(jokeListener... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://tarunbuilditbigger.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });


            myApiService = builder.build();
        }

        mJokeListener =params[0];

        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            String Error= e.getMessage();
            String msg="Please Check Your Internet Connection \n"+Error;
            return msg;


        }
    }

    @Override
    protected void onPostExecute(String result) {

        mJokeListener.OnJokeReceivedListener(result);

    }
}