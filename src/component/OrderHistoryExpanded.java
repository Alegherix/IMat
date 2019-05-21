package component;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class OrderHistoryExpanded {

    public OrderHistoryExpanded() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/order_history_expanded.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
