package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Bus Drivers");
        primaryStage.setScene(new Scene(root, 691, 407));
        FileCh filesCh = new FileCh(new FileChooser(), primaryStage);
        Controller controller = loader.getController();
        BusPark Arr = new BusPark();
        controller.inject(filesCh, Arr);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
