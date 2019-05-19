package component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javax.swing.text.html.ImageView;
import javax.xml.soap.Text;
import java.io.IOException;

public class ProductView {
    @FXML Label productTitle;
    @FXML ImageView productImage;
    @FXML Text productInfo;
    @FXML Label priceTag;
    @FXML Button minusButton;
    @FXML TextField quantityField;

    public ProductView(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/product_view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


