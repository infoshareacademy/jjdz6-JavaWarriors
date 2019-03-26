package com.infoshareacademy.pl.Twitter;


import com.google.gson.Gson;

public class TweetParser {
    Gson gson= new Gson();

    public Tweet parseJson(String json){
        Tweet tweet = gson.fromJson(json, Tweet.class);
        return tweet;
    }


}
