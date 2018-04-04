package com.austinshootthej;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    LinkedList<Album> albumLinkedList = new LinkedList<Album>();
    LinkedList<Song> playList = new LinkedList<Song>();
    Album gamerAlbum = new Album("Gamer Album");
    Album rapAlbum = new Album("Rap Album");
    albumLinkedList.add(gamerAlbum);
    albumLinkedList.add(rapAlbum);

    gamerAlbum.addSong("GGEZ NO RE!", "0:30");
    gamerAlbum.addSong("CCCCC----OOOMBO Breaker", "2:22");
    gamerAlbum.addSong("EXTRA THICC", "7:10");

    rapAlbum.addSong("F B G M", "3:05");
    rapAlbum.addSong("LIT AF", "4:20");
    rapAlbum.addSong("BLT","2:08");


    albumLinkedList.add(gamerAlbum);
    albumLinkedList.add(rapAlbum);


    //addSongs(playList,findAlbum("Gamer Album",albumLinkedList),"GGEZ NO RE!");
    //addSongs(playList,gamerAlbum,"EXTRA THICC");

        playSongs(playList,albumLinkedList);
        printList(playList);




    }

    public static void playSongs(LinkedList<Song> playList, LinkedList<Album> albumLinkedList) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> i = playList.listIterator();
        boolean quit = false;
        boolean goingForward = true;


        if (playList.isEmpty()) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now Playing:\n"+i.next().printSong());

        }
        printMenu();

       while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Now leaving playlist");
                    quit = true;
                    break;

                case 1:
                    System.out.println("What album do you want to add from?");
                    String albumAnswer = scanner.nextLine();
                    System.out.println("What song do you want to add?");
                    String songAnswer = scanner.nextLine();

                    i.add(addSongs(playList,findAlbum(albumAnswer,albumLinkedList),songAnswer));
                    break;




                case 2:
                    if(!goingForward){
                        if(i.hasNext()){
                            i.next();
                        }
                        goingForward = true;
                    }
                    if(i.hasNext()){
                        System.out.println("Now Playing: "+ i.next().printSong());

                    }else{
                        System.out.println("Reached the end of the Playlist");
                        goingForward = false;
                    }
                    break;



                case 4:
                    System.out.println("What song do you want to remove?");


                    i.add(addSongs(playList,findAlbum(albumAnswer,albumLinkedList),songAnswer));
                    break;





            }


       }
    }

    public static Song addSongs(LinkedList<Song> playList, Album album ,String title){

        if(album == null){
           return null;
       }

        Song checkSong = album.getSong(title);

        if(checkSong == null ){

        }else {
            return checkSong;
            //playList.add(checkSong);

        }
        return null;

    }

    public static Album findAlbum(String title,LinkedList<Album> albumLinkedList){


        ListIterator<Album> albumListIterator = albumLinkedList.listIterator();
        while(albumListIterator.hasNext()){
            Album tempAlbum = albumListIterator.next();
            int comparison = tempAlbum.getTitle().compareToIgnoreCase(title);
            if(comparison == 0){
                System.out.println("Album Found!"+ tempAlbum.getTitle());
                return tempAlbum;
            }
        }
        System.out.println("No album found");
        return null;
    }




    public static Song removeSongs(LinkedList<Song> playList,String title){


        // here is where we stopped make a method to remove from the list ***
        Song checkSong = album.getSong(title);

        if(checkSong == null ){

        }else {
            return checkSong;
            //playList.add(checkSong);

        }
        return null;

    }



    private static void printList(LinkedList<Song> linkedList) {
        ListIterator<Song> i = linkedList.listIterator();
        if (!i.hasNext())
        {
            System.out.println("No songs to print.");
        }else {
            System.out.println("Songs in the Playlist: \n"+"=========================");
            while (i.hasNext()) {
                System.out.println(i.next().getTitle());
                System.out.println("=========================");
            }

        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - add song\n" +
                "2 - play next song\n" +
                "3 - print menu options\n" +
                "4 - remove song");
    }



    }



