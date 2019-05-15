package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javax.swing.text.html.ImageView;
import javax.xml.soap.Text;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Default Controller klass
 */
public class Controller implements Initializable {


    // Default view
    @FXML ImageView logotype;
    @FXML ImageView shoppingCart;
    @FXML Button searchButton;
    @FXML Button myPagesButton;
    @FXML Button cashOutButton;
    @FXML TextField searchField;
    @FXML Accordion menu;
    @FXML TitledPane offers;

    // Product view
    @FXML Label productTitle;
    @FXML ImageView productImage;
    @FXML Text productInfo;
    @FXML Label priceTag;
    @FXML Button plusButton;
    @FXML Button minusButton;
    @FXML TextField quantityField;

    //List item
    @FXML ImageView productImageListView;
    @FXML Label productNameListView;

    @FXML Button plusButtonListView;
    @FXML Button minusButtonListView;
    @FXML TextField quantityFieldListView;

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
