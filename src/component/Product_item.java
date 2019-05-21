package component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import util.Product;


import java.io.IOException;

public class Product_item extends AnchorPane {

    @FXML Label productName;
    @FXML ImageView productImageListView;
    @FXML Label price;

    @FXML Button plusButtonListView;
    @FXML Button minusButtonListView;
    @FXML TextField quantityFieldListView;

    public Product_item(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/product_item.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        getProduct();
        Product prod = new Product();
        prod.getId();
        prod.getCategory();
        prod.getName();
        prod.isEcological();
        prod.getPrice();
        prod.getUnit();*/


    }
    public Product getProduct(){
        Product prod = new Product();
        prod.getCachedProducts().get(1);
        return prod;
    }

}
