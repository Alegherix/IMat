package component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class Product_item extends AnchorPane {

    @FXML ImageView productImageListView;
    @FXML Label productNameListView;

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

    }
}
