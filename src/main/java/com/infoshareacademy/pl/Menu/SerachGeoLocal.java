package com.infoshareacademy.pl.Menu;

import twitter4j.*;

import java.util.List;
import java.util.Scanner;

public class SerachGeoLocal {
    public static void searchOfGeo () {
        Scanner scanner = new Scanner(System.in);
            try {
                Query query = new Query(scanner.nextLine()); //

                GeoLocation location = new GeoLocation(54.35774,18.62987);
                Query.Unit unit = Query.KILOMETERS; // or Query.MILES;
                query.setGeoCode(location, 10, unit);

                QueryResult result;

                do {
                    TwitterFactory tf = new TwitterFactory();
                    Twitter twitter = tf.getInstance();
                    result = twitter.search(query);
                    List<Status> tweets = result.getTweets();

                    for (Status tweet : tweets) {
                        String rawJSON = TwitterObjectFactory.getRawJSON(tweet);
                        System.out.println(rawJSON);
                    }

                } while ((query = result.nextQuery()) != null);

            } catch (TwitterException te) {
                System.out.println("Failed to search tweets: " + te.getMessage());
                System.exit(-1);
            }



        }
}
