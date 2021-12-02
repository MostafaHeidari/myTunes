package MyTunes.Bll;

import MyTunes.Bll.util.SongFilter;
import MyTunes.Dal.SongsDAO;
import MyTunes.be.Songs;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class SongManager
{
    private SongsDAO songsDAO;
    private SongFilter songFilter;


    public SongManager() throws IOException{
        songsDAO = new SongsDAO();
        songFilter = new SongFilter();
    }




    public Songs addSong(String title, String artist, String genre, int playtime, String location, int id) {
        return songsDAO.addSong(title, artist, genre, playtime, location);
    }

    public Songs updateSong(Songs song, String title, String artist, String genre, int playtime, String location) {
        return songsDAO.updateSong(song,title,artist,genre,playtime,location);
    }

    public Songs deleteSong(Songs songDelete) {
        return songsDAO.deleteSong(songDelete);
    }


    public List <Songs> getSongs() {
        List<Songs> allSongs = (List<Songs>) songsDAO.getSongs();
        return allSongs;
    }
    public ObservableList<Songs> searchSongs(ObservableList<Songs> songs, String text) {
        return songFilter.searchSong(songs,text);
    }
}
