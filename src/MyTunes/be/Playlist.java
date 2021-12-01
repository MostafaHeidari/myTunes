package MyTunes.be;

import java.util.ArrayList;
import java.util.List;


public class Playlist {

    private final int id;
    private String name;
    private int time;
    private ArrayList songs;


    public Playlist(int id, String name, String title) {
        this.id = id;
        this.name = name;
        this.time = 0;
        songs = new ArrayList();

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime(){
        return time;
    }

    public List<Songs> getSongs(){
        return songs;
    }

    // Add a song to playlist
    // parameter song
    public void addSong(Songs song) {
        songs.add(song);
    }

    // remove a song from a playlist
    // parameter song

    public void removeFromPlaylist(Songs song) {
        songs.remove(song);
    }


}
