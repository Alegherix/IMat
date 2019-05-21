package application;


import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;

import javafx.stage.Stage;


public class Main extends Application {

    /**
     * Dimensionerna för Root Scene kan vi ändra
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/default_view3.fxml"));
        primaryStage.setTitle("Imat");
        primaryStage.setScene(new Scene(root, 1480, 900));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
