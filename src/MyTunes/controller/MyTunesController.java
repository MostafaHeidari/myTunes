package MyTunes.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;


import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MyTunesController implements Initializable {


    public Button newSong;

    public TableView tableOfSongs;
    public TableView SongsOnPlaylist;
    public TableView TabelOfPlaylist;
    public TableColumn songTitleCol;
    public TableColumn songArtistCol;
    public TableColumn songCatCol;
    public TableColumn songDurationCol;
    public ImageView musicRewind;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void handleMoveSongToPL(ActionEvent actionEvent) {
    }

    public void handleDeleteSongOnPL(ActionEvent actionEvent) {

    }


    public Button getNewSong() {
        return newSong;
    }

    public void setNewSong(Button newSong) {
        this.newSong = newSong;
    }


    public void opensNewSong(ActionEvent AddSong)
    {

    }

    public void AddSong(ActionEvent actionEvent) {
        Button addSong =new Button();
        addSong.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                Button []AddSong = new Button[0];
            }
        });
    }
}
