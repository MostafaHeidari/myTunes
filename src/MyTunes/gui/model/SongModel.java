package MyTunes.gui.model;

import MyTunes.be.Songs;

public class SongModel<MRSLogicFacade> {
    private MRSLogicFacade logiclayer;

  public Songs createSong(String title, String artist, String categori, int time) {
        SongModel logiclayer = null;
        Songs song = logiclayer.createSong(title,artist,categori,time);
        Songs.add(song);

        return song;
    }
    public void deleteSong(Songs song)
    {
        SongModel logiclayer = null;
        logiclayer.deleteSong(song);
        Songs.remove(song);
    }
}
