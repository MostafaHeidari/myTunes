package MyTunes.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
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

    public void handleEditSong(ActionEvent actionEvent) {
    }

    public void handleDeletePlaylist(ActionEvent actionEvent) {
    }

    public void handleNewPlaylist(ActionEvent actionEvent) {
    }

    public void handleEditPlaylist(ActionEvent actionEvent) {
    }

    public void handleMoveSongUp(ActionEvent actionEvent) {
    }

    public void handleMoveSongDown(ActionEvent actionEvent) {
    }

    public void handleCloseApp(ActionEvent actionEvent) {
    }

    public void handleNewSong(ActionEvent actionEvent) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyTunes/gui/view/newSong.fxml"));
        root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Songs");
        stage.centerOnScreen();
        stage.show();
    }


    public void handleDeleteSong(ActionEvent actionEvent) {
    }

    public void handleMusicPlayPause(ActionEvent actionEvent) {
    }

    public void handleMusicForward(ActionEvent actionEvent) {
    }

    public void handleMusicRewind(ActionEvent actionEvent) {
    }

}
