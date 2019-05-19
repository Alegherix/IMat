package component;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GridView extends AnchorPane{
    @FXML GridPane gridPane;

    public GridView(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/grid_view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





