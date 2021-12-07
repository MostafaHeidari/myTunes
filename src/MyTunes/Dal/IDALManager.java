package MyTunes.dal;

import MyTunes.be.Songs;
import javafx.collections.ObservableList;

import java.util.List;

public interface IDALManager {
    public Songs addSong(String title, String artist, String genre, String playtime, String location);


    public Songs updateSong(Songs song, String title, String artist, String genre, String playtime, String location);


    public Songs deleteSong(Songs songDelete);


    public List<Songs> getSongs();

 }
