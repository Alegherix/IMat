package util;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class CreditCard implements PaymentMethod {

    private CreditCard.CardType cardType;
    private String holdersName;
    private int validMonth;
    private int validYear;
    private String cardNumber;
    private int verificationCode;

    public CreditCard() {
    }

    public CreditCard(CreditCard.CardType cardType, String holdersName, int validMonth, int validYear, String cardNumber, int verificationCode) {
        setCardType(cardType);
        setHoldersName(holdersName);
        setValidMonth(validMonth);
        setValidYear(validYear);
        setCardNumber(cardNumber);
        setVerificationCode(verificationCode);
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CreditCard.CardType getCardType() {
        return this.cardType;
    }

    public void setCardType(CreditCard.CardType cardType) {
        this.cardType = cardType;
    }

    public String getHoldersName() {
        return this.holdersName;
    }

    public void setHoldersName(String holdersName) {
        this.holdersName = holdersName;
    }

    public int getValidMonth() {
        return this.validMonth;
    }

    public void setValidMonth(int validMonth) {
        if(validMonth > 0 && validMonth < 13) this.validMonth = validMonth;
    }

    public int getValidYear() {
        return this.validYear;
    }

    public void setValidYear(int validYear) {
        if(validYear >= new Date().getYear()) this.validYear = validYear;
    }

    public int getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(int verificationCode) {
        if(verificationCode >= 100 && verificationCode <= 999) this.verificationCode = verificationCode;
    }

    @Override
    public boolean isValid() {
        System.out.println(cardType);
        System.out.println(cardNumber);
        System.out.println(holdersName);
        return cardType != null && !cardNumber.isEmpty() && validMonth != 0 && validYear != 0 && verificationCode != 0 && !holdersName.isEmpty();
    }

    public enum CardType {
        MASTER_CARD, VISA
    }

    public List<CreditCard> getCachedPaymentInfo() {
        try {
            return Files
                    .readAllLines(Paths.get(getClass().getClassLoader().getResource("cache/payment-info.json").toURI())).stream()
                    .map(c -> new Gson().fromJson(c, CreditCard.class))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            return Collections.emptyList();
        }
    }

    public void cachePaymentInfo() {
        try {
            Files.write(Paths.get(getClass().getClassLoader().getResource("cache/payment-info.json").toURI())
                    , Collections.singleton(new Gson().toJson(this)), StandardOpenOption.APPEND);
            System.out.println("caching card");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return cardNumber;
    }
}