package MyTunes.Dal;

import MyTunes.be.Songs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SongsDAO< AllSongs> {

    private Object AllSongs;
    private Object Artist;

    public List<Songs> getAllsongs() throws FileNotFoundException, IOException {
        List<Songs> allSongs = new ArrayList<>();

        return (List<Songs>) AllSongs;
    }


    public Songs addSong(String title, String artist, String genre, int playtime, String location) {
        return null;
    }

    public Songs updateSong(Songs song, String title, String artist, String genre, int playtime, String location) {
    }

    public Songs deleteSong(Songs songDelete) {
    }

    public Songs getSongs() {
        ArrayList <Songs> allSongs = new ArrayList<>();
    }
}
