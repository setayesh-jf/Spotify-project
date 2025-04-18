package Spotify;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist (String Title, User Owner) throws InvalidOperationException{
        throw new InvalidOperationException("The regular user can not be createPlaylist");
    }


    @Override
    public void playMusic (Music music) throws InvalidOperationException{
     if (playingLimit == 0){
        throw new InvalidOperationException("user can not be play music");
     }
     music.play();
     playingLimit--;
    }

    @Override
    public void buyPremium (User owner, int month){
     owner.setBehavior(new PremiumBehavior(month));
    }


}
