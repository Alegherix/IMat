package util;


import com.google.gson.Gson;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.ShoppingItem;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Product extends AnchorPane {

    private int productId;
    private String category;
    private String name;
    private Boolean isEcological;
    private double price;
    private String unit;

    public Product() {
    }

    public Product(int productId, String category, String name, Boolean isEcological, double price, String unit) {
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.isEcological = isEcological;
        this.price = price;
        this.unit = unit;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isEcological() {
        return this.isEcological;
    }

    public void setIsEcological(Boolean isEco) {
        this.isEcological = isEco;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getUnitSuffix() {
        String[] tokens = this.getUnit().split("/");
        return tokens.length == 2 ? tokens[1] : "";
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String toString() {
        return this.productId + " - " + this.name;
    }

    public void cacheProducts(List<ShoppingItem> shoppingItemList) {
        try {
            Files.write(Paths.get(getClass().getClassLoader().getResource("cache/shopping-items.json").toURI())
                    , Collections.singleton(new Gson().toJson(shoppingItemList)), StandardOpenOption.APPEND);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public List<List<ShoppingItem>> getCachedProducts() {
        try {
            return Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("cache/shopping-items.json").toURI()))
                    .stream()
                    .map(p -> new Gson().fromJson(p, ShoppingItem[].class))
                    .map(Arrays::asList)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            return Collections.emptyList();
        }
    }
}