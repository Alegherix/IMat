package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javax.swing.text.html.ImageView;
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
