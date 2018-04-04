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


        playSongs(playList,albumLinkedList);





    }

    public static void playSongs(LinkedList<Song> playList, LinkedList<Album> albumLinkedList) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> i = playList.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        boolean firstPlay = true;


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
                    if(addSongs(playList,findAlbum(albumAnswer,albumLinkedList),songAnswer)== null){
                        System.out.println("Song not found!");
                        printMenu();
                        break;
                    }else{
                        int count = 0;
                        if(i.hasNext()){
                            while(i.hasNext()){
                                i.next();
                                count++;
                            }
                        }
                        i.add(addSongs(playList,findAlbum(albumAnswer,albumLinkedList),songAnswer));
                        System.out.println("Song Found! Added to playlist.");
                        if(i.hasPrevious()){
                            for(int b = count; b>-1; b--){
                                i.previous();
                            }
                        }
                    }

                    printMenu();
                    break;




                case 2:
                if(firstPlay == true){
                    while(i.hasPrevious()){
                        i.previous();

                    }
                    firstPlay = false;
                }
                    if(!goingForward){
                        if(i.hasNext()){
                            i.next();
                        }
                        goingForward = true;
                    }
                    if(i.hasNext()){
                        System.out.println("Now Playing: "+ i.next().printSong());

                    }else{
                        System.out.println("Reached the end of the Playlist. Starting over! \n");

                        if(i.hasPrevious()){
                            while(i.hasPrevious()){
                                i.previous();
                            }

                        }
                        System.out.println("Now Playing: " + i.next().printSong());
                        goingForward = true;
                    }
                    printMenu();
                    break;

                case 3:
                    if(goingForward){
                        if(i.hasPrevious()){
                            i.previous();
                        }

                        }goingForward = false;
                    if(i.hasPrevious()){
                        System.out.println("Now playing: " + i.previous().printSong());
                    }else{
                        System.out.println("Now playing: "+ playList.getFirst().printSong());
                    }
                    printMenu();
                    break;


                case 4:
                    if(!goingForward){
                        if(i.hasNext()){
                            i.next();
                            i.previous();
                            System.out.println("Now Playing: "+ i.next().printSong());
                        }
                        goingForward = true;
                    }else if(i.hasPrevious()){
                        i.previous();
                        System.out.println("Now Playing: " + i.next().printSong());
                    }
                    printMenu();
                    break;


                case 5:

                    System.out.println("What song do you want to remove?");
                    String songToRemove = scanner.nextLine();
                    boolean didRemove = false;
                    if(i.hasPrevious()){
                        while(i.hasPrevious()){
                        i.previous();
                        }
                    }
                    while (i.hasNext()){
                        Song tempSong = i.next();
                        String comparison = tempSong.getTitle();
                        if(comparison.equalsIgnoreCase(songToRemove)){

                            i.remove();
                            System.out.println("Song: " + songToRemove + " removed!" );
                            didRemove = true;

                        }
                    }
                        if(didRemove == false) {
                            System.out.println("Song not found!");
                        }
                        printMenu();
                        break;







                case 6:
                    printList(playList);
                    break;

                    default:
                        System.out.println("Not a valid option");
                        printMenu();
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


        }
        return null;

    }

    public static Album findAlbum(String title,LinkedList<Album> albumLinkedList){


        ListIterator<Album> albumListIterator = albumLinkedList.listIterator();
        while(albumListIterator.hasNext()){
            Album tempAlbum = albumListIterator.next();
            int comparison = tempAlbum.getTitle().compareToIgnoreCase(title);
            if(comparison == 0){
                //System.out.println("Album Found!"+ tempAlbum.getTitle());
                return tempAlbum;
            }
        }
        System.out.println("No album found");
        return null;
    }




    public static Song removeSongs(LinkedList<Song> playList,String title){


        // here is where we stopped make a method to remove from the list ***
        ListIterator<Song> songListIterator = playList.listIterator();
        while (songListIterator.hasNext()){
            Song tempSong = songListIterator.next();
            String comparison = tempSong.getTitle();
            if(comparison.equalsIgnoreCase(title)){

                return tempSong;
            }
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
                "3 - play previous song\n" +
                "4 - repeat song\n" +
                "5 - remove song \n" +
                "6 - print playlist");
    }



    }



