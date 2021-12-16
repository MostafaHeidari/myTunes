package mytunes.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mytunes.be.NewPlaylist;
import mytunes.gui.model.PlaylistModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlaylistController implements Initializable {

    public TextField nameGiver;
    private Label alertLabel;
    private PlaylistModel playlistModel;
    private TextField nameField;

    private javafx.scene.control.Button cancelButton;
    @FXML
    private javafx.scene.control.Button safeButton;
    private boolean isEditing = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            playlistModel = new PlaylistModel();
        }catch (IOException ex){
            alertLabel.setText("Alert: No connection to database.");
        }
    }

    //Metoden bliver brugt til at så cancel knappen til at lukke vinduet
    @FXML
    private void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    // metoden bliver brug titl at give info om en redigering af en playliste
    public  void setInfo(NewPlaylist selectedItem){
        isEditing = true;
        nameField.setText(selectedItem.getPlaylistName());
    }

    // metoden bliver brugt til at gemme en playliste i collenen
    public void savePlaylist(ActionEvent actionEvent) {
            String playlistName = nameGiver.getText();
            this.playlistModel.addPlaylist(playlistName);
    }
}
