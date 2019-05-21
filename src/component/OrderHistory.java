package component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class OrderHistory extends AnchorPane {

    @FXML TitledPane orderHistoryTitledPane;
    @FXML VBox orderHistoryPaneToAddTo;

    public OrderHistory() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/order_history.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public VBox getOrderHistoryPaneToAddTo() {
        return orderHistoryPaneToAddTo;
    }

    public TitledPane getOrderHistoryTitledPane() {
        return orderHistoryTitledPane;
    }

    public void setOrderHistoryTitledPane(TitledPane orderHistoryTitledPane) {
        this.orderHistoryTitledPane = orderHistoryTitledPane;
    }

}
