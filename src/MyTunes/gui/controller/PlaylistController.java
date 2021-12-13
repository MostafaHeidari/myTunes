package MyTunes.gui.controller;

import MyTunes.be.NewPlaylist;
import MyTunes.dal.DALManager;
import MyTunes.gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private DALManager PlaylistModel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            playlistModel = new PlaylistModel();
        }catch (IOException ex){
            alertLabel.setText("Alert: No connection to database.");
        }
    }

    //cancel action
    @FXML
    private void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    void setInfo(NewPlaylist selectedItem){
        isEditing = true;
        nameField.setText(selectedItem.getPlaylistName());
    }

    // savePlaylist
    public void savePlaylist(ActionEvent actionEvent) {
            String playlistName = nameGiver.getText();
            this.PlaylistModel.addPlaylist(playlistName);
    }
}
