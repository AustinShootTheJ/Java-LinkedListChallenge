package com.austinshootthej;

public class Song {

    private String title;
    private String duration;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    private String getDuration() {
        return duration;
    }

public String printSong(){
    return "Title: " + this.title + "\n" + "Duration:" + this.duration;
}
}
