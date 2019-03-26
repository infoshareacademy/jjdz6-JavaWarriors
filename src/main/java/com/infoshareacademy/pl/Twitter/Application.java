package com.infoshareacademy.pl.Twitter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;


import com.google.gson.Gson;
import twitter4j.util.*;
import twitter4j.*;
import twitter4j.GeoLocation;
import twitter4j.api.*;
import twitter4j.conf.*;
import twitter4j.json.*;
import twitter4j.auth.*;

public class Application {

    public static Twitter getTwitterinstance() {
        /**
         * if not using properties file, we can set access token by following way
         */
        /*		ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true)
//                .setJSONStoreEnabled(true)
//                .setOAuthConsumerKey("cSsvIzyZhzypbCoyaKk8f9y1D")
//                .setOAuthConsumerSecret("5gUcBBhk1RXZRa3UOLHbgJhl7ry3tbkWaIN1sB1220LZUxAC6D")
//                .setOAuthAccessToken("1099024186377453570-t6kKV6pykUO5v3Yuht3vVbnCHHKf4I")
//                .setOAuthAccessTokenSecret("C5VAj1uOvymyAV09hGs7Fb8oPlRZs7s9OiIVn4uck4edq");*/
        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();

        //Twitter twitter = TwitterFactory.getInstance();
        return twitter;

    }

    public static String createTweet(String tweet) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Status status = twitter.updateStatus("creating baeldung API");
        return status.getText();
    }

    public static List<String> getTimeLine() throws TwitterException {
        Twitter twitter = getTwitterinstance();
        List<Status> statuses = twitter.getHomeTimeline();
        return statuses.stream().map(
                item -> item.getText()).collect(
                Collectors.toList());
    }

    public static String sendDirectMessage(String recipientName, String msg) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        DirectMessage message = twitter.sendDirectMessage(recipientName, msg);
        return message.getText();
    }

    public static List<String> searchtweets() throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Query query = new Query("source:twitter4j baeldung");
        QueryResult result = twitter.search(query);
        List<Status> statuses = result.getTweets();
        return statuses.stream().map(
                item -> item.getText()).collect(
                Collectors.toList());
    }

    public static void streamFeed() throws FileNotFoundException {

        StatusListener listener = new StatusListener(){

            File file = new File("tweets.txt");
            PrintWriter saveFile = new PrintWriter("tweets.txt");

            int tweetCounter = 0;

            @Override
            public void onException(Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg) {
                //System.out.println("Got a status deletion notice id:" + arg.getStatusId());
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onStatus(Status status) {

                //GeoLocation loc = status.getGeoLocation();
                //System.out.println(status.getUser().getName() + " : " + status.getText());

                //System.out.println(status.getUser().getName() + " : " + status.getText() +status.getLang()+ status.getSource()+status.getCreatedAt());
                //FilterQuery filter = new FilterQuery();
                //filter.locations(loc);
                String rawJSON = TwitterObjectFactory.getRawJSON(status);
                Gson gson = new Gson();
                if (tweetCounter < 50) {
                   // System.out.println(rawJSON);
                    saveFile.println(rawJSON);
                    Tweet obj2 = gson.fromJson(rawJSON, Tweet.class);
                    System.out.println("Created at: " + obj2.getCreatedAt() + ", id: " + obj2.getId() + "text: " + obj2.getText() + ", user_name: " + obj2.getUser().getName());
                    tweetCounter++;
                } else {
                    saveFile.close();



                }
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }
        };

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        twitterStream.addListener(listener);
        //GeoLocation geoLocation = new GeoLocation(54.35774,18.62987);
        //Query.Unit unit = Query.KILOMETERS; // or Query.MILES;
        //query.setGeoCode(location, 10, unit);
        double[][] boundingBox= {
                {
                        54.2721, 18.3804

                }
                , {
                54.4674, 18.7811,
            }

        };

        FilterQuery filterLocation = new FilterQuery();
        filterLocation.locations(boundingBox);


        twitterStream.sample();
                //filter(filterLocation);
        //twitterStream.shutdown();

    }

}