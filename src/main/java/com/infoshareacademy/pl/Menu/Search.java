package com.infoshareacademy.pl.Menu;

import com.infoshareacademy.pl.Twitter.TweetObject;
import com.infoshareacademy.pl.Twitter.TweetParser;
import com.infoshareacademy.pl.Twitter.TwitterUtils;
import twitter4j.TwitterException;

import java.util.List;
import java.util.Scanner;

public class Search {



    public static void callTwitterSearch() throws TwitterException{
        System.out.println("Wprowadź kryteria wyszukiwania:");
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();
        List<String> tweetsList = TwitterUtils.searchtweets(query);
        TweetParser parser = new TweetParser();
        for (String item : tweetsList
             ) {
            TweetObject tweet = parser.parseJson2Object(item);
            System.out.println(tweet.toString());
        }

    }

    public static void menuSecondSearch() throws TwitterException {
        System.out.println("   Wybierz opcję:    ");
        System.out.println("1. Szukaj po słowie kluczowym");
        System.out.println("2. Przeglądaj w czasie rzeczywistym (Stream");
        System.out.println("3. Wczytaj wyniki wyszukiwania z pliku");
        //System.out.println("4. Open Geolocal");
        //while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        //System.out.println("Wprowadź kryteria wyszukiwania i wciśnij ENTER:");
                        //String input = scanner.nextLine();
                        callTwitterSearch();
                        break;
                    case 2:
                        TwitterUtils.streamFeed();
                        break;
                    case 3:
                        ReadFromFile.readFromFileKey("tweets.txt");
                        break;
                    //case 4:
                    //SearchKeyWord.readFromFileGeo();
                    default:
                        System.out.println("Dziękujemy");


                }

                //break;
            } catch (Exception e) {
               System.out.println("Błąd Wpisz jeszcze raz");
            }

        }


}