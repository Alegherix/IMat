package component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.BillingInformation;

import java.io.IOException;

public class CustomerContactInfoHandler extends AnchorPane {

    @FXML TextField pNumField;
    @FXML TextField fNameField;
    @FXML TextField sNameField;
    @FXML TextField adressField;
    @FXML TextField zipField;
    @FXML TextField zipState;
    @FXML TextField mailField;
    @FXML TextField mailField2;
    @FXML TextField phoneField;
    @FXML Button saveCustomerDataBtn;
    @FXML RadioButton homeDeliveryBtn;
    @FXML RadioButton storeDeliveryButton;

    private BillingInformation billingInformation;

    public CustomerContactInfoHandler() {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/customer_contact_view.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            billingInformation = new BillingInformation().getCachedBillingInfo();
            fillFields();
    }

    @FXML
    public void saveCustomerData(){
        this.getChildren().forEach(System.out::println);
    }

    public void fillFields(){
        if(billingInformation!=null){
            pNumField.setText(billingInformation.getSsn());
            fNameField.setText(billingInformation.getFirstName());
            sNameField.setText(billingInformation.getLastName());
            adressField.setText(billingInformation.getAddress());
            zipField.setText(billingInformation.getZip());
            zipState.setText(billingInformation.getState());
            mailField.setText(billingInformation.getEmail());
            mailField2.setText(billingInformation.getEmail());
            phoneField.setText(billingInformation.getPhone());
            if(billingInformation.isHomeDelivery()){
                homeDeliveryBtn.selectedProperty().setValue(true);
            }
            else{
                storeDeliveryButton.selectedProperty().setValue(true);
            }
        }
    }



}
