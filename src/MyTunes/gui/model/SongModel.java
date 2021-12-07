package MyTunes.gui.model;

import MyTunes.bll.SongManager;
import MyTunes.be.Songs;
import MyTunes.bll.ISongManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class SongModel{

    private ObservableList<Songs> allSongs = FXCollections.observableArrayList();
    private final ISongManager songManager;


    public SongModel() throws IOException {
        songManager = new SongManager();
    }

    public ObservableList<Songs>getAllSongs(){
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(songManager.getSongs());
        return allSongs;
    }

    public void addSong(String title,String artist, String genre, String playtime,String location){
        songManager.addSong(title,artist,genre,playtime,location);
    }

    public void deleteSong (Songs songDelete){
        songManager.deleteSong(songDelete);
    }

    public void updateSong(Songs songDelete, String title, String artist, String genre, String playtime, String location){
        songManager.updateSong(songDelete, title, artist,genre,playtime,location);
    }

    public ObservableList<Songs> searchSongs(ObservableList<Songs> songs, String text ){
        return songManager.searchSongs(songs,text);
    }
}
