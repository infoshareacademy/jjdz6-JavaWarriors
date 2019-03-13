package com.infoshareacademy.pl.Twitter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class Application {

    public static Twitter getTwitterinstance() {
        /**
         * if not using properties file, we can set access token by following way
         */
        /*		ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setJSONStoreEnabled(true)
                .setOAuthConsumerKey("cSsvIzyZhzypbCoyaKk8f9y1D")
                .setOAuthConsumerSecret("5gUcBBhk1RXZRa3UOLHbgJhl7ry3tbkWaIN1sB1220LZUxAC6D")
                .setOAuthAccessToken("1099024186377453570-t6kKV6pykUO5v3Yuht3vVbnCHHKf4I")
                .setOAuthAccessTokenSecret("C5VAj1uOvymyAV09hGs7Fb8oPlRZs7s9OiIVn4uck4edq");*/
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
                //System.out.println(status.getUser().getName() + " : " + status.getText());
                //System.out.println(status.getUser().getName() + " : " + status.getText() +status.getLang()+ status.getSource()+status.getCreatedAt());
                String rawJSON = TwitterObjectFactory.getRawJSON(status);
                if (tweetCounter < 50) {
                    System.out.println(rawJSON);
                    saveFile.println(rawJSON);
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

        twitterStream.sample("pl");
        //twitterStream.shutdown();

    }

}