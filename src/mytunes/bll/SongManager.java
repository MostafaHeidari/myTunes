package mytunes.bll;

import javafx.collections.ObservableList;
import mytunes.be.Songs;
import mytunes.bll.util.SongFilter;
import mytunes.dal.DALManager;
import mytunes.dal.IDALManager;

import java.io.IOException;
import java.util.List;

public class SongManager implements mytunes.bll.ISongManager
{
    private IDALManager dalManager;
    private SongFilter songFilter;


    public SongManager() throws IOException{
        dalManager = new DALManager();
        songFilter = new SongFilter();
    }

    public Songs addSong(String title, String artist, String genre, String playtime, String location) {
        return dalManager.addSong(title, artist, genre, playtime, location);
    }

    public Songs updateSong(Songs song, String title, String artist, String genre, String playtime, String location) {
        return dalManager.updateSong(song,title,artist,genre,playtime,location);
    }

    public boolean deleteSong(Songs songDelete) {
        if (songDelete !=null){
            return dalManager.deleteSong(songDelete);
        }
        return false;
    }

    //getSongs
    public List <Songs> getSongs() {
        List<Songs> allSongs = dalManager.getSongs();
        return allSongs;
    }
    public ObservableList<Songs> searchSongs(ObservableList<Songs> songs, String text) {
        return songFilter.searchSong(songs,text);
    }
}
