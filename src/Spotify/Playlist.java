package Spotify;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList<Music> playlist = new ArrayList<>();
    private User Owner;
    private String title;

    public Playlist(User Owner, String title){
        this.Owner = Owner;
        this.title = title;
    }

    public ArrayList<Music> getPlaylist(){
        return playlist;
    }

    public User getOwner(){
        return Owner;
    }

    public String getTitle(){
        return title;
    }

    public void editTitle(String newTitle, String password) throws InvalidOperationException{
        if (!this.Owner.getPassword().equals(password)){
            throw new InvalidOperationException("password is not true");
        }

        this.title = newTitle;
        System.out.println("the playlist was successfully renamed");
    }


    public void addMusic(Music music, String password) throws InvalidOperationException{
        if (!this.Owner.getPassword().equals(password)){
            throw new InvalidOperationException("password is not true");
        }

        if (playlist.contains(music)){
            throw new InvalidOperationException("do not add music");
        }

        playlist.add(music);
    }


    public void removeMusic(Music music, String password) throws InvalidOperationException{
        if (!this.Owner.getPassword().equals(password)){
            throw new InvalidOperationException("password is not true");
        }

        if (!playlist.contains(music)){
            throw new InvalidOperationException("music not found in the playlist");
        }

        playlist.remove(music);
    }


    public ArrayList<Music> searchPlaylist(String title){
        ArrayList<Music> foundPlaylist = new ArrayList<>();
        for (Music music : playlist){
            if (music.getTitle().equals(title)){
                foundPlaylist.add(music);
            }
        }

        return foundPlaylist.isEmpty() ? null : foundPlaylist;
    }


    public Music searchPlaylist(String title, User singer){
        for (Music music : playlist){
            if (music.getTitle().equals(title) && music.getSinger().equals(singer)){
                return music;
            }
        }

        return null;
    }


    public void playPlaylist(){
        Scanner scn = new Scanner(System.in);
        for (Music music : playlist){
            music.play();
            System.out.println("click next to stop playlist: ");
            String click = scn.nextLine();
            if (click.equalsIgnoreCase("next")){
                System.out.println("playlist stopped");
                return;
            }
        }
        System.out.println("playlist finished");
    }
}
