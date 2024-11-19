import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Playlist {
    private ArrayList<Song> songs;

    public Playlist () {
        songs = new ArrayList<>();
    }

    public Playlist(String filename) throws FileNotFoundException {
        songs = new ArrayList<>();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            songs.add(new Song(line));
        }

    }

    private void load(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            songs.add(new Song(line));
        }
    }

    public void save(String filename) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        toString();
        writer.println(toString());
        writer.close();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void addSongs(int index, Song song) {
        songs.add(index, song);
    }

    public void addSongs(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            songs.add(new Song(line));
        }
    }

    public Song getSong(int index) {
        return songs.get(index);
    }

    public int getSongCount() {
        return songs.size();
    }

    public void playSong(int index) {
        songs.get(index).incrementNumPlays();
    }

    public Song removeSong(int index) {
        Song a = songs.get(index);
        songs.remove(index);
        return a;
    }

    public String favoriteArtist() {
        ArrayList<String> artists = new ArrayList<>();
        if (songs.isEmpty()) {
            return null;
        }
        for (Song song : songs) {
           String a =  song.getArtist();
           if (a != null) {
               artists.add(a);
           }
        }
        Map<String, Integer> favorites = new HashMap<>();
        for (String artist : artists) {
            if (!favorites.containsKey(artist)) {
                favorites.put(artist, 1);
            }
            else {
                favorites.put(artist, favorites.get(artist) + 1);
            }
        }
        String k = "";
        Integer v = 0;
        for (Map.Entry<String, Integer> entry : favorites.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (v == 0) {
                k = key;
                v = value;
            }
            else {
                if (value > v) {
                    k = key;
                    v = value;
                }
            }
        }
        return k;
    }

    public String totalPlaytime () {
        int tmin = 0;
        int tsec = 0;
        for (Song song : songs) {
            tmin += song.getMinutes();
            tsec += song.getSecond();
        }
        tsec += tsec * 60;
        tmin = tsec / 60;
        int thour = tmin / 60;
        tmin = tmin % 60;
        tsec = tsec % 60;

        if (thour < 0) {
            return tmin + ":" + tsec;
        }
        else return thour + ":" + tmin + ":" + tsec;
    }

    public String toString() {
        String s = "";
        for (Song song : songs) {
            s.concat(song.toString());
        }
        return s;
    }
}
