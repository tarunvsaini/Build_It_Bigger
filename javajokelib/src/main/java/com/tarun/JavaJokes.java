package com.tarun;

import java.util.Random;

public class JavaJokes {


    public static String getJavaJokes() {


        String[] javaJokes = {"Q: What's object-oriented way to become wealthy?\n\n " +
                "A: Inheritance."
                ,"Q: Why do Java programmers have to wear glasses?\n\n" +
                "A: Because they don't C#."
                , "Q:What is programmer's favourite hangout place? \n\n" +
                "A: Foo Bar"
                ,"A programmer had a problem and he used Java Now he has a ProblemFactory."
                ,"Two bytes meet. The first byte asks, Are you ill?\n" +
                "The second byte replies, No, just feeling a bit off."
                ,"Q: how many programmers does it take to change a light bulb?\n\n" +
                "A: none, that is a hardware problem"
                ,"A SQL query goes into a bar, walks up to two tables and asks, Can I join you?"
                ,"To understand what recursion is, you must first understand recursion."

        };

        Random random = new Random();
        int jokeId = random.nextInt(javaJokes.length);

        return javaJokes[jokeId];


    }

}
