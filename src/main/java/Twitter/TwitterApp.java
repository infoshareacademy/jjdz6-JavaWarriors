package Twitter;

import java.util.List;
import java.util.stream.Collectors;

import twitter4j.DirectMessage;
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

import static Twitter.Application.getTwitterinstance;


public class TwitterApp {

    public static List<String> searchtweets() throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Query query = new Query("lang:pl");
        QueryResult result =  twitter.search(query);
//        System.out.println(result);
        System.out.println(result.getCount());
        List<Status> statuses = result.getTweets();
        return statuses.stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

    public static void streamFeed() {

        StatusListener listener = new StatusListener() {

            @Override
            public void onException(Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg) {
                System.out.println("Got a status deletion notice id:" + arg.getStatusId());
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
                System.out.println(status.getUser().getName() + " : " + status.getText());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }
        };

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        twitterStream.addListener(listener);

        twitterStream.sample();

    }

    public static void main(String[] args) throws TwitterException {

       streamFeed();
    }
}
