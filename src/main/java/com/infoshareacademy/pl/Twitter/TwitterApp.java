package com.infoshareacademy.pl.Twitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import twitter4j.*;
import twitter4j.json.DataObjectFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.infoshareacademy.pl.Twitter.Application.streamFeed;
import static java.sql.DriverManager.println;
import static twitter4j.conf.ConfigurationContext.getInstance;

public class TwitterApp {


    public static void main(String[] args) throws TwitterException, IOException, FileNotFoundException {


        Application.streamFeed();


    }
}

