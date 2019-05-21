package component;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import util.Product;

import java.io.IOException;


public class GridView extends AnchorPane{

    @FXML GridPane gridPane;

    public GridView() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/grid_view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }



        fillGridPane();

    }

    public void fillGridPane() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                gridPane.add(getProduct(), i, j);
            }
        }
    }

    public Product_item getProduct(){
       return new Product_item();
    }
}








