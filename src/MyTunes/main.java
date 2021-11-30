package MyTunes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class main  {
    private static int bredde = 800;
    private static int højde = 700;


    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gui/view/myTunes.fxml")));
        primaryStage.setTitle("MyTunes");
        primaryStage.setScene(new Scene(root, bredde, højde));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void launch(String[] args) {
    }
}

