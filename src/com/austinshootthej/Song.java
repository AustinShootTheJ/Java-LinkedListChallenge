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

    public String getDuration() {
        System.out.println(this.duration);
        return duration;
    }

public String printSong(){
    return "\nTitle: " + this.title + "\n" + "Duration:" + this.duration;
}
}
