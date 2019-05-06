package component;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CustomerDataHandler extends AnchorPane {

    public CustomerDataHandler() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/customer_data.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
