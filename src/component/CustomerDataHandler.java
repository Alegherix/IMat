package component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CustomerDataHandler extends AnchorPane {

    @FXML Button shoppingListBtn;
    @FXML Button orderHistoryBtn;
    @FXML Button customerDataBtn;

    @FXML AnchorPane shoppingListPane;
    @FXML AnchorPane customerDataPane;
    @FXML AnchorPane orderHistoryPane;
    @FXML AnchorPane customerDataHandlingPane;
    @FXML VBox innerShopingVBox;


    public CustomerDataHandler() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/customer_data.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fillWithData();

    }

    private void fillWithData() {
        BuylistHandler buylistHandler = new BuylistHandler();
        buylistHandler.addTestEntries();
        buylistHandler.getSavedShoppingMap().forEach((k, v) -> innerShopingVBox.getChildren().add(k));
    }


    @FXML
    public void customerDataPaneToFront(){
        customerDataPane.toFront();
    }

    @FXML
    public void orderHistoryToFront(){
        orderHistoryPane.toFront();
    }

    @FXML
    public void shoppingListToFront(){
        shoppingListPane.toFront();
    }







}
