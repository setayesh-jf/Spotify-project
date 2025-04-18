package Spotify;
import java.util.ArrayList;

public class Music {
   private String title;
   private User singer;
   private int numberOfStream = 0;
   private static ArrayList<Music> allMusics = new ArrayList<>();

   public Music(String title, User singer){
       this.title = title;
       this.singer = singer;
       allMusics.add(this);
   }

   public String getTitle(){
       return title;
   }


   public User getSinger(){
       return singer;
   }

   public void play(){
       System.out.println("music title: " + this.title + "song singer: " + this.singer.getUsername() + "playing now");
      this.numberOfStream++;
   }


   public static ArrayList<Music> search(String title){
       ArrayList<Music> foundMusic = new ArrayList<>();
       for (Music music : allMusics){
           if (music.getTitle().equals(title)){
             foundMusic.add(music);
           }
       }

       return foundMusic.isEmpty() ? null : foundMusic;
   }


   public static Music search(String title, User singer){
       for (Music music : allMusics){
      if (music.getTitle().equals(title) && music.getSinger().equals(singer)){
          return music;
      }
       }
       return null;
   }

}
