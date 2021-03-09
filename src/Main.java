package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Contacts");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("main_view.fxml"));
        AnchorPane rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
