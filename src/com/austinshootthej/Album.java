package com.austinshootthej;

import java.util.LinkedList;
import java.util.ListIterator;

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
    public String getTitle(){
        return title;
    }

    public Song getSong(String title){
        ListIterator<Song> songListIterator = this.songs.listIterator();
        while(songListIterator.hasNext()){
            Song temSong = songListIterator.next();
            int comparison = temSong.getTitle().compareToIgnoreCase(title);
            if(comparison == 0){
                //System.out.println("Song Found! Added to playlist."+ temSong.getTitle());
                return temSong;
            }
        }

        return null;
    }



    }


