import Spotify.User;
import Spotify.Playlist;
import Spotify.Music;
import Spotify.InvalidOperationException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        testRegularUserCreatePlaylist();
        testUpgradeToPremium();
        testPlayMusicLimit();
        testPlaylistOperations();
        testMusicSearch();
        testEditPlaylist();
        testInvalidCases();
        testFollowFunction();
        testRemoveMusicFromPlaylist();
        testSearchInPlaylist();
    }

    public static void testRegularUserCreatePlaylist() {
        try {
            System.out.println("▶️ testRegularUserCreatePlaylist");
            User user = new User("taraneh", "137330tara");
            user.createPlaylist("popular my singers");
            System.out.println("❌ Expected exception not thrown");
        } catch (InvalidOperationException e) {
            System.out.println("✅ Caught expected exception: " + e.getMessage());
        }
    }

    public static void testUpgradeToPremium() {
        try {
            System.out.println("\n▶️ testUpgradeToPremium");
            User user = new User("roza", "set77889@");
            user.buyPremium(user, 3);
            user.createPlaylist("the cool songs");
            System.out.println("✅ Playlist created successfully, Total Playlists: " + user.getPlaylists().size());
        } catch (InvalidOperationException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public static void testPlayMusicLimit() {
        try {
            System.out.println("\n▶️ testPlayMusicLimit");
            User user = new User("maryam", "star7788");
            User artist = new User("farhad", "sophani@fff");
            Music song = new Music("Hello", artist);

            for (int i = 0; i < 6; i++) {
                System.out.println("Play " + (i + 1) + ":");
                user.playMusic(song);
            }
        } catch (InvalidOperationException e) {
            System.out.println("✅ Caught expected exception: " + e.getMessage());
        }
    }

    public static void testPlaylistOperations() {
        try {
            System.out.println("\n▶️ testPlaylistOperations");
            User user = new User("karen", "11220pass@@");
            user.buyPremium(user, 1);
            user.createPlaylist("My Favorites");

            User artist = new User("shirin", "almasss77Q@");
            Music song1 = new Music("You Say", artist);
            Music song2 = new Music("Bonbast", artist);

            Playlist playlist = user.getPlaylists().getFirst();
            playlist.addMusic(song1, "11220pass@@");
            playlist.addMusic(song2, "11220pass@@");

            System.out.println("✅ Playlist contains " + playlist.getPlaylist().size() + " songs");


            System.out.println("Testing playlist play:");
            playlist.playPlaylist();
        } catch (InvalidOperationException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public static void testMusicSearch() {
        try {
            System.out.println("\n▶️ testMusicSearch");
            User artist = new User("farshad", "222wwwqq");
            new Music("Khaterat To", artist);
            new Music("Barghard", artist);

            ArrayList<Music> results = Music.search("Khaterat To");
            System.out.println("✅ Found " + (results != null ? results.size() : 0) + " songs");

            Music specific = Music.search("Unknown Song", artist);
            System.out.println("✅ Specific search: " + (specific != null ? "Found" : "Not found"));
        } catch (InvalidOperationException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public static void testEditPlaylist() {
        try {
            System.out.println("\n▶️ testEditPlaylist");
            User user = new User("roshanak", "raz6788@@");
            user.buyPremium(user, 1);
            user.createPlaylist("old songs");

            Playlist playlist = user.getPlaylists().getFirst();
            playlist.editTitle("New Title", "raz6788@@");
            System.out.println("✅ Playlist title updated: " + playlist.getTitle());
        } catch (InvalidOperationException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public static void testFollowFunction() {
        try {
            System.out.println("\n▶️ testFollowFunction");
            User user1 = new User("roya", "arezoo998h");
            User user2 = new User("sareh", "tabann@@!11");

            user1.follow(user2);

            System.out.println("✅ sareh following count: " + user1.getFollowingList().size());
            System.out.println("✅ sareh follower count: " + user2.getFollowerList().size());
        } catch (InvalidOperationException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public static void testRemoveMusicFromPlaylist() {
        try {
            System.out.println("\n▶️ testRemoveMusicFromPlaylist");
            User user = new User("neghar", "677yyj44@@");
            User artist = new User("neghin", "lllkkknnn");
            user.buyPremium(user, 1);
            user.createPlaylist("Removing Songs");

            Music song = new Music("Song to Remove", artist);
            Playlist playlist = user.getPlaylists().getFirst();
            playlist.addMusic(song, "677yyj44@@");
            playlist.removeMusic(song, "677yyj44@@");

            System.out.println("✅ Playlist size after removal: " + playlist.getPlaylist().size());
        } catch (InvalidOperationException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public static void testSearchInPlaylist() {
        try {
            System.out.println("\n▶️ testSearchInPlaylist");
            User user = new User("arash", "abcd44433");
            user.buyPremium(user, 1);
            user.createPlaylist("rock playlist");

            User artist = new User("roshan", "taraneh0099@@@");
            Music song1 = new Music("Search Song 1", artist);
            Music song2 = new Music("Search Song 2", artist);

            Playlist playlist = user.getPlaylists().getFirst();
            playlist.addMusic(song1, "abcd44433");
            playlist.addMusic(song2, "abcd44433");

            System.out.println("✅ Playlist size: " + playlist.getPlaylist().size());


            ArrayList<Music> results = playlist.searchPlaylist("Search Song 1");
            System.out.println("✅ Found songs: " + (results != null ? results.size() : 0));

        } catch (InvalidOperationException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public static void testInvalidCases() {
        try {
            System.out.println("\n▶️ testInvalidCases");


            new User("roz", "123");
            new User("roz", "123");
            System.out.println("❌ Expected exception not thrown");
        } catch (InvalidOperationException e) {
            System.out.println("✅ Caught expected exception (duplicate user): " + e.getMessage());
        }

        try {
            new User("raha", "1234");
            System.out.println("❌ Expected exception not thrown");
        } catch (InvalidOperationException e) {
            System.out.println("✅ Caught expected exception (short password): " + e.getMessage());
        }
    }
}