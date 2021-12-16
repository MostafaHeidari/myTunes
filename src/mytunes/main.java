package mytunes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class main extends Application {
private static int width = 800;
private static int height = 650;

// Metoden bliver brugt til at starte programmet og få brugergrænsefladen frem
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/myTunes.fxml"));
        primaryStage.setTitle("mytunes");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
