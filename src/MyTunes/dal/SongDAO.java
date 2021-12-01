package MyTunes.dal;

import MyTunes.be.Songs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Denne DAO-klasse kan udføre CRUD-operationer på database sang tabellen.

public class SongDAO< AllSongs> {

    private Object AllSongs;
    private Object Artist;

    public List<Songs> getAllsongs() throws FileNotFoundException, IOException {
        List<Songs> allSongs = new ArrayList<>();

        return (List<Songs>) AllSongs;
    }



}
