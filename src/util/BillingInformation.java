package util;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class BillingInformation {
    private String email = "";
    private String phone = "";
    private String ssn = "";
    private String zip = "";
    private String firstName = "";
    private String lastName = "";
    private String address = "";

    public BillingInformation(String email, String phone, String ssn, String zip, String firstName, String lastName, String address) {
        setEmail(email);
        setPhone(phone);
        setSsn(ssn);
        setZip(zip);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
    }

    public BillingInformation() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isValid(){
        return !(email.isEmpty() && ssn.isEmpty() && zip.isEmpty() && address.isEmpty() && firstName.isEmpty() && lastName.isEmpty());
    }

    public BillingInformation getCachedBillingInfo() {
        try {
            List<String> billingInfo = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("cache/billing-info.json").toURI()));
            if(billingInfo.size() > 0) {
                return new Gson().fromJson(
                        billingInfo.get(0)
                        , BillingInformation.class
                );
            }
            else return new BillingInformation();
        } catch (IOException | URISyntaxException e) {
            return new BillingInformation();
        }
    }

    public void cacheBillingInfo() {
        try {
            Files.write(Paths.get(getClass().getClassLoader().getResource("cache/billing-info.json").toURI())
                    , Collections.singleton(new Gson().toJson(this)));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
