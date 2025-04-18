package Spotify;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();


    public User(String username, String password, UserBehavior behavior) throws InvalidOperationException{

        for (User user : allUsers){
            if (user.getUsername().equals(username)){
                throw new InvalidOperationException("username is not unique");
            }
        }

        if (password.length() < 8){
            throw new InvalidOperationException("the password length must more 8 or 8");
        }

        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }


    public String getUsername(){
        return username;
    }


   public String getPassword(){
        return password;
   }


    public UserBehavior getBehavior(){
        return behavior;
    }

    public void setBehavior(UserBehavior behavior){
        this.behavior = behavior;
    }

    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }


    public void follow (User user){
       this.followingList.add(user);
        user.followerList.add(this);
    }

    public void createPlaylist (String Title, User Owner){
        this.behavior.createPlaylist(Title, Owner);
    }

    public void playMusic (Music music){
        this.behavior.playMusic(music);
    }

    public  void buyPremium (User owner, int month){
        this.behavior.buyPremium(owner, month);
    }
}
