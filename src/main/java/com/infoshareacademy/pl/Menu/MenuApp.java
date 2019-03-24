package com.infoshareacademy.pl.Menu;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


import sun.plugin.AppletStatusListener;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.List;

public class MenuApp {
    public static void main(String[] args) throws IOException, TwitterException {
       SerachGeoLocal.searchOfGeo();


    }

    private static void metodafor() throws IOException, TwitterException {
        Scanner scanner = new Scanner(System.in);
        String writeTweetQuery = scanner.nextLine();
        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        Query query = new Query(writeTweetQuery);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + " : " + status.getText() + " : " + status.getGeoLocation());

        }


    }






}

