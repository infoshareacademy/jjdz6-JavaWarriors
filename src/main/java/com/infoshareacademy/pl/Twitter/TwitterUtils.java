package com.infoshareacademy.pl.Twitter;

import com.google.gson.Gson;
import twitter4j.*;
import twitter4j.TwitterResponse.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TwitterUtils {

    public static Twitter getTwitterinstance() {

        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        return twitter;

    }

    public static void searchTweets() {

    }

    public static List<String> searchtweets(String userQuery) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Query query = new Query(userQuery);
        QueryResult result = twitter.search(query);

        List<String> tweetList = new ArrayList<String>();
        result.getTweets();
        for (Status tweet : result.getTweets()) {
            String json = TwitterObjectFactory.getRawJSON(tweet);
            tweetList.add(json);
        }

        return tweetList;
    }

    public static void streamFeed() throws FileNotFoundException {

        //File file = new File("tweets1.txt");
        PrintWriter saveFile = new PrintWriter("tweets.txt");

        StatusListener listener = new StatusListener(){


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

                String rawJSON = TwitterObjectFactory.getRawJSON(status);
                Gson gson = new Gson();
                TweetParser parser = new TweetParser();


                if (tweetCounter < 50) {

                    TweetObject obj2 = parser.parseJson2Object(rawJSON);
                    System.out.println("Created at: " + obj2.getCreatedAt() + ", id: " + obj2.getId() + "text: " + obj2.getText() + ", user_name: " + obj2.getUser().getName());
                    saveFile.println(obj2.toString());
                    tweetCounter++;
                } else {
                    //saveFile.close();
                   // break;
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
                        18.3804, 54.2721

                }
                , {
                18.7811, 54.4674
        }

        };

        FilterQuery filterLocation = new FilterQuery();
        filterLocation.locations(boundingBox);


        twitterStream.sample();
        //twitterStream.filter(filterLocation);
        //twitterStream.shutdown();

    }
}
