package com.infoshareacademy.pl.Twitter;

public class Tweet {
    String createdAt;
    Long id;
    String text;
    User user;  //String place;

    public String getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //    public String getPlace() {
//        return place;
//    }
}
