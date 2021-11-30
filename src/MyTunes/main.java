package MyTunes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
private static int bredde = 800;
private static int højde = 750;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/myTunes.fxml"));
        primaryStage.setTitle("MyTunes");
        primaryStage.setScene(new Scene(root, bredde, højde));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
