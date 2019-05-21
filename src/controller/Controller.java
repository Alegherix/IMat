package controller;

import component.CustomerDataHandler;
import component.GridView;
import component.Product_item;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Default Controller klass
 */
public class Controller implements Initializable {


    //
    @FXML StackPane dynamicStackPane;

    // Default view
    @FXML ImageView logotype;
    @FXML ImageView shoppingCart;
    @FXML Button searchButton;
    @FXML Button myPagesButton;
    @FXML Button cashOutButton;
    @FXML TextField searchField;
    @FXML Accordion menu;
    @FXML TitledPane offers;


    @FXML ScrollPane dynamicPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dynamicPane.setContent(new GridView());
    }

    /**
     * Switch to My Pages
     */
    @FXML
    public void enableMyPage(){
        CustomerDataHandler customerDataHandler = new CustomerDataHandler();
        if(!dynamicStackPane.getChildren().contains(customerDataHandler)){
            dynamicStackPane.getChildren().add(customerDataHandler);
        }
        else{
            int index = dynamicStackPane.getChildren().indexOf(customerDataHandler);
            dynamicStackPane.getChildren().get(index).toFront();
        }

    }

    /**
     * Switch to Product Page
     */
    @FXML
    public void enableProductView(){
        if(!dynamicStackPane.getChildren().contains(dynamicPane)){
            GridView gridView = new GridView();
            dynamicPane.setContent(gridView);
        }
        else{
            int index = dynamicStackPane.getChildren().indexOf(dynamicPane);
            dynamicStackPane.getChildren().get(index).toFront();
        }

    }


}
