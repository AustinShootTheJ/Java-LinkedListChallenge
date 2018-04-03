package com.austinshootthej;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
    LinkedList<Album> albumLinkedList = new LinkedList<Album>();
    Album gamerAlbum = new Album("Gamer Album");
    Album rapAlbum = new Album("Rap Album");

    gamerAlbum.addSong("GGEZ NO RE!", "0:30");
    gamerAlbum.addSong("CCCCC----OOOMBO Breaker", "2:22");
    gamerAlbum.addSong("EXTRA THICC", "7:10");

    rapAlbum.addSong("F B G M", "3:05");
    rapAlbum.addSong("LIT AF", "4:20");
    rapAlbum.addSong("BLT","2:08");


    albumLinkedList.add(gamerAlbum);
    albumLinkedList.add(rapAlbum);

    printSongs(albumLinkedList);




    }

    public static void printSongs(LinkedList<Album> linkedList){
        Iterator<Album> i = linkedList.iterator();
        boolean goingForward = true;
        while(i.hasNext()){
            i.next().printSongs();
        }
        }
    }



