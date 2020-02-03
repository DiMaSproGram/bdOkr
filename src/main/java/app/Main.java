package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("table.fxml"));
//        loader.load();
        Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("fxml/table.fxml"));
        primaryStage.setTitle("OKR");
        primaryStage.setScene(new Scene(root, 620, 500));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);
    }
}
