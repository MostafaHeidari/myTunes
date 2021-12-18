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
// Metoden bliver brugt til at slette og tilføje en sang på listen allSongs
    public ObservableList<Songs>getAllSongs(){
        allSongs.clear();
        allSongs.addAll(songManager.getSongs());
        return allSongs;
    }
// Metoden bliver brugt til at tilføje en sang i brugergrænsefladen
    public void addSong(String title,String artist, String genre, int playtime,String location){
        Songs s = songManager.addSong(title,artist,genre,playtime,location); //db
        allSongs.add(s);
    }
// Metoden bliver brugt til at slette en sang
    public void deleteSong (Songs songDelete){
        boolean succes = songManager.deleteSong(songDelete);
        if(succes==true)
            allSongs.remove(songDelete);
    }

}
