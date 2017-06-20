package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.util.Log;

/**
 * Created by Tarun on 20-06-2017.
 */

public class JokeAndroidTest extends ApplicationTestCase {


    public JokeAndroidTest() {
        super(Application.class);
    }


    public void testJokeLoad()
    {

        try {
            new EndpointsAsyncTask().execute(new jokeListener() {
                @Override
                public void OnJokeReceivedListener(String joke)
                {
                    assertNotNull("Joke",joke);
                    assertFalse("Joke is empty",joke.isEmpty());

                }
            });
        }catch (Exception e)
        {
            fail("Test Failed: "+e);

        }


    }
}
