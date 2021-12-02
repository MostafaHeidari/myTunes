package MyTunes.gui.model;

import MyTunes.Bll.SongManager;
import MyTunes.be.Songs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class SongModel{

    private ObservableList<Songs> allSongs = FXCollections.observableArrayList();
    private final SongManager songManager;


    public SongModel() throws IOException {
        songManager = new SongManager();
    }

    public ObservableList<Songs>getAllSongs(){
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(songManager.getSongs());
        return allSongs;
    }

    public void addSong(String title,String artist, String genre, int playtime,String location, int id){
        songManager.addSong(title,artist,genre,playtime,location,id);
    }

    public void deleteSong (Songs songDelete){
        songManager.deleteSong(songDelete);
    }

    public void updateSong(Songs songDelete, String title, String artist, String genre, int playtime, String location){
        songManager.updateSong(songDelete, title, artist,genre,playtime,location);
    }

    public ObservableList<Songs> searchSongs(ObservableList<Songs> songs, String text ){
        return songManager.searchSongs(songs,text);
    }
}
