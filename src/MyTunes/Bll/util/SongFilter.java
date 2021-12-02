package MyTunes.Bll.util;

import MyTunes.be.Songs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongFilter {
    private ObservableList<Songs>songSearch = FXCollections.observableArrayList();


    public ObservableList<Songs> searchSong(ObservableList<Songs> songs, String text) {
        songSearch.clear();
        for( Songs Songs : songs);{

            if(Songs.getTitle().toLowerCase().startsWith(text.toLowerCase())){
                songSearch.add((Songs) songs);
            }
        }
        return songSearch;
    }
}
