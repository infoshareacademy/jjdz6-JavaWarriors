package com.infoshareacademy.pl.Twitter;


import com.google.gson.Gson;

public class TweetParser {
    Gson gson= new Gson();

    public TweetObject parseJson2Object(String json){
        TweetObject tweet = gson.fromJson(json, TweetObject.class);
        return tweet;
    }


}
