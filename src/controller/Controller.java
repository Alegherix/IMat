package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;


import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Default Controller klass
 */
public class Controller implements Initializable {


    @FXML ImageView logotype;
    @FXML ImageView shoppingCart;

    @FXML Button searchButton;
    @FXML Button myPagesButton;
    @FXML Button cashOutButton;

    @FXML TextField searchField;

    @FXML Accordion menu;
    @FXML TitledPane offers;

    /**
     * Används om vi istället vill binda funktionalitet till listeners i java kod, istället för i .fxml dokumenten
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }



    public void enableMyPage(){
        myPagesButton.setOnAction(e -> System.out.println("Mina sidor clicked"));
    }

}
