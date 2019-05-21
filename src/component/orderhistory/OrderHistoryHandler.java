package component.orderhistory;


import component.OrderHistory;
import component.OrderHistoryItem;
import se.chalmers.cse.dat216.project.Order;
import se.chalmers.cse.dat216.project.ShoppingItem;
import util.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderHistoryHandler {

    private List<List<ShoppingItem>> shoppingItemLists;

    public OrderHistoryHandler() {
        Product product = new Product();
        shoppingItemLists = product.getCachedProducts();
    }


    public List<OrderHistory> getOrderHistories(){
        List<OrderHistory> orderHistories = new ArrayList<>();
        for (int i = 0; i < shoppingItemLists.size(); i++) {
            OrderHistory orderHistory = new OrderHistory();
            orderHistory.getOrderHistoryTitledPane().setText(createTitle(i));
            orderHistory.getOrderHistoryPaneToAddTo().getChildren().addAll(createOrderHistoryItemList(i));
            orderHistories.add(orderHistory);
        }
        return orderHistories;
    }

    public String createTitle(int index){
        StringBuilder sb = new StringBuilder();
        // Denna delen bör bytas ut mot datum som tas ifrån cachad data
        sb.append("Datum ");
        sb.append(emptySpace());

        sb.append(index);
        sb.append(emptySpace());

        sb.append(getAmountOfProducts(index));
        sb.append(emptySpace());

        sb.append(getTotalForShoppingList(index)).append("kr");
        return sb.toString();
    }

    public String emptySpace(){
        return "                                                        ";
    }

    public Double getTotalForShoppingList(int index){
        return shoppingItemLists.get(index).stream().mapToDouble(ShoppingItem::getTotal).sum();
    }

    public List<OrderHistoryItem> createOrderHistoryItemList(int index){
        List<ShoppingItem> itemsToParse = shoppingItemLists.get(index);
        List<OrderHistoryItem> orderItems = new ArrayList<>();

        OrderHistoryItem detailLabel = new OrderHistoryItem();
        detailLabel.getProductNameLabel().setStyle("-fx-font-weight: bold");
        detailLabel.setProductNameLabel("Produkt");
        detailLabel.setUnitPriceLabel("Enhetspris");
        detailLabel.setAmountLabel("Antal produkter");
        detailLabel.setTotalSumLabel("Kostnad");
        orderItems.add(detailLabel);

        for(ShoppingItem item : itemsToParse){
            OrderHistoryItem orderHistoryItem = new OrderHistoryItem();
            orderHistoryItem.setProductNameLabel(item.getProduct().getName());
            orderHistoryItem.setUnitPriceLabel(item.getProduct().getPrice() + item.getProduct().getUnit());
            orderHistoryItem.setAmountLabel(String.valueOf(item.getAmount()));
            orderHistoryItem.setTotalSumLabel(item.getTotal() + "kr");
            orderItems.add(orderHistoryItem);
        }
        return orderItems;
    }

    public int getAmountOfProducts(int index){
        return shoppingItemLists.get(index).size();
    }

    public static void main(String[] args) {
        OrderHistoryHandler orderHistoryHandler = new OrderHistoryHandler();
        System.out.println(orderHistoryHandler.getTotalForShoppingList(1));
    }

}
