package component.shoppingList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BuylistExpandedComponent extends AnchorPane {

    @FXML AnchorPane buyListPane;

    // Initialize Component
    public BuylistExpandedComponent() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/buy_list_expanded.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}