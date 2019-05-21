package component;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import util.BillingInformation;
import util.CreditCard;

import java.io.IOException;
import java.util.List;

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

    @FXML TextField firstCardNameField;
    @FXML TextField firstCardNumberField;
    @FXML TextField firstMMField;
    @FXML TextField firstYYField;
    @FXML TextField firstCVVField;

    @FXML ChoiceBox<CreditCard> carcChoiceBox;
    @FXML TextField secondCardNameField;
    @FXML TextField secondCardNumberField;
    @FXML TextField secondMMField;
    @FXML TextField secondYYField;
    @FXML TextField secondCVVField;

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
            fillContactFields();
            fillCCField();
            fillChoiceBox();
    }

    @FXML
    public void saveCustomerData(){
        new BillingInformation(
                mailField.getText(), phoneField.getText(),
                pNumField.getText(), zipState.getText(),
                zipField.getText(), fNameField.getText(),
                sNameField.getText(), adressField.getText(),
                homeDeliveryBtn.selectedProperty().get())
                .cacheBillingInfo();
    }

    public void fillContactFields(){
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

    public void fillCCField(){
        // Borde bytas mot att hämta kort som markerats som primary
        CreditCard cc = new CreditCard();
        List<CreditCard> creditCards =  cc.getCachedPaymentInfo();
        CreditCard primaryCard = creditCards.get(0);

        firstCardNameField.setText(primaryCard.getHoldersName());
        firstCardNumberField.setText(primaryCard.getCardNumber());
        firstMMField.setText(String.valueOf(primaryCard.getValidMonth()));
        firstYYField.setText(String.valueOf(primaryCard.getValidYear()));
        firstCVVField.setText(String.valueOf(primaryCard.getVerificationCode()));
    }

    @FXML
    public void saveCardData(){
        System.out.println("Trying to Save CC");
        CreditCard.CardType type = firstCardNumberField.getText().charAt(0)==5? CreditCard.CardType.MASTER_CARD : CreditCard.CardType.VISA;
        new CreditCard(
                type, firstCardNameField.getText(),
                Integer.valueOf(firstMMField.getText()), Integer.valueOf(firstYYField.getText()),
                firstCardNumberField.getText(), Integer.valueOf(firstCVVField.getText()))
                .cachePaymentInfo();
        System.out.println("Saved CreditCardInfo");
    }

    public void fillChoiceBox(){
        carcChoiceBox.getItems().addAll(new CreditCard().getCachedPaymentInfo());
        carcChoiceBox.getSelectionModel().selectFirst();
        carcChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            secondCardNameField.setText(newValue.getHoldersName());
            secondCardNumberField.setText(newValue.getCardNumber());
            secondCVVField.setText(String.valueOf(newValue.getVerificationCode()));
            secondMMField.setText(String.valueOf(newValue.getValidMonth()));
            secondYYField.setText(String.valueOf(newValue.getValidYear()));
        });
    }

    public boolean numberVerification(){
        if(firstCardNumberField.getText().charAt(0)!=4 || firstCardNumberField.getText().charAt(0)!=5){
            // Här kan man visa en text för att de är felaktigt Input
            return false;
        }
        return true;
    }


}
