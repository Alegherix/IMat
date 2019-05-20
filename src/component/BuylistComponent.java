package component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BuylistComponent extends AnchorPane {


    // List -> med Saker dem köper,
    @FXML
    TitledPane expandedPane;

    // Initialize Component
    public BuylistComponent() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/buy_list.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initializeBorderText();
    }


    public void initializeBorderText(){
        expandedPane.setText("Test                  50");
    }

    public TitledPane getExpandedPane() {
        return expandedPane;
    }


}
