package MyTunes.bll;

import MyTunes.be.Songs;
import javafx.collections.ObservableList;

import java.util.List;

public interface ISongManager {
    public Songs addSong(String title, String artist, String genre, String playtime, String location);


    public Songs updateSong(Songs sonng, String title, String artist, String genre, String playtime, String location);


    public boolean deleteSong(Songs songDelete);


    public List<Songs> getSongs();


    public ObservableList<Songs> searchSongs(ObservableList<Songs> songs, String text);
}
