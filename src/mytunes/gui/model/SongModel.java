package mytunes.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes.be.Songs;
import mytunes.bll.ISongManager;
import mytunes.bll.SongManager;

import java.io.IOException;

public class SongModel{

    private final ObservableList<Songs> allSongs= FXCollections.observableArrayList();
    private final ISongManager songManager;


    public SongModel() throws IOException {
        songManager = new SongManager();
    }

    public ObservableList<Songs>getAllSongs(){
        allSongs.clear();
        allSongs.addAll(songManager.getSongs());
        return allSongs;
    }

    public void addSong(String title,String artist, String genre, String playtime,String location){
        Songs s = songManager.addSong(title,artist,genre,playtime,location); //db
        allSongs.add(s); // brugerflade
    }

    public void deleteSong (Songs songDelete){
        boolean succes = songManager.deleteSong(songDelete);
        if(succes==true)
            allSongs.remove(songDelete);
    }




}
