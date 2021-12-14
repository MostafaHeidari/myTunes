package mytunes.bll.util;

import mytunes.be.Songs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongFilter {
    private ObservableList<Songs>songSearch = FXCollections.observableArrayList();


    public ObservableList<Songs> searchSong(ObservableList<Songs> songs, String text) {
        songSearch.clear();
        for( Songs song : songs){

            if(song.getTitle().toLowerCase().startsWith(text.toLowerCase())){
                songSearch.add((Songs) songs);
            }
        }
        return songSearch;
    }
}
