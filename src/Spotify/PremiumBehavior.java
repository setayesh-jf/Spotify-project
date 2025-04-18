package Spotify;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
        this.month = month;
    }


    public int getMonth(){
        return month;
    }


    @Override
    public void createPlaylist (String Title, User Owner){
        Playlist playList = new Playlist(Owner, Title);
        Owner.getPlaylists().add(playList);

    }

    @Override
    public void playMusic (Music music){
        music.play();
    }

    @Override
    public void buyPremium (User owner, int month){
       this.month += month;
    }
}
