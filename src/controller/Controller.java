package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Default Controller klass
 */
public class Controller implements Initializable {

    @FXML Button testButton;
    @FXML Button myPagesButton;
    @FXML StackPane dynamicStackPane;


    /**
     * Används om vi istället vill binda funktionalitet till listeners i java kod, istället för i .fxml dokumenten
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enableMyPage();
    }


    @FXML
    public void shopButtonActivated(){
        System.out.println("Shop Button was clicked");
    }

    public void enableMyPage(){
        myPagesButton.setOnAction(e -> System.out.println("Mina sidor clicked"));
    }


}
