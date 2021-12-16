package mytunes.bll;

import javafx.collections.ObservableList;
import mytunes.be.Songs;

import java.util.List;

public interface ISongManager {
    public Songs addSong(String title, String artist, String genre, String playtime, String location);



    public boolean deleteSong(Songs songDelete);


    public List<Songs> getSongs();}



