package com.infoshareacademy.pl.Twitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.json.DataObjectFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.infoshareacademy.pl.Twitter.Application.streamFeed;
import static java.sql.DriverManager.println;
import static twitter4j.conf.ConfigurationContext.getInstance;


public class TwitterApp {


    public static void main(String[] args) throws TwitterException, IOException, FileNotFoundException {



       /* List<Status> statuses = twitter.getHomeTimeline();
        for (Status status : statuses) {
            String rawJSON = ory.getRawJSON(status);
            println("@" + status.getUser().getScreenName() + " - " + status.getText());
            println("rawJASON= "+ rawJSON);
            String fileName = "statuses/" + status.getId() + ".json";
            toWrite.add(rawJSON + "\n"+" "+"\n");
            System.out.println(fileName + " - " + status.getText());
        }
        saveStrings("saved", toWrite.toArray(new String[0]));  /// Processing way...
        System.out.print("\ndone.");*/

        Application.streamFeed();
        //StatusListener listener = new StatusListener();



        // twitterStream.addListener(listener);

        //twitterStream.sample(); twitterStream = new TwitterStreamFactory(getInstance();

    }
}

