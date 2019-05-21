package component;

import component.orderhistory.OrderHistoryHandler;
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
    @FXML VBox currentOrderPane;

    private OrderHistoryHandler orderHistoryHandler;

    public CustomerDataHandler() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/customer_data.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        customerDataPaneToFront();
    }


    private void fillOrderHistoryData(){
//        orderHistoryHandler = new OrderHistoryHandler();
//        currentOrderPane.getChildren().addAll(orderHistoryHandler.getOrderHistories());
    }


    /**
     * Se till att ladda in den nya Modellen direkt.
     */
    @FXML
    public void customerDataPaneToFront(){
        customerDataPane.getChildren().add(new CustomerContactInfoHandler());
        customerDataPane.toFront();

    }

    @FXML
    public void orderHistoryToFront(){
        if(orderHistoryHandler==null){
            fillOrderHistoryData();
        }
        orderHistoryPane.toFront();
    }

    @FXML
    public void shoppingListToFront(){
        shoppingListPane.toFront();
    }


}
