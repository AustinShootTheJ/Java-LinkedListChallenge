package com.austinshootthej;

import java.util.LinkedList;

public class Album {
    private LinkedList<Song> songs = new LinkedList<Song>();
    private String title;
    public Album(LinkedList<Song> songs, String title) {
        this.songs = songs;
        this.title = title;
    }

    public Album(String title){
    this.title = title;
    }

    public void addSong(String title, String duration){
        this.songs.add(new Song(title,duration));
    }

    public void printSongs(){
        for(int i=0; i<this.songs.size(); i++){
            System.out.println(this.songs.get(i).printSong());
        }
    }
    public void getTitle(){
        System.out.println("---------------\n" + "Cover: " + this.title  + "\n---------------");
    }


}
