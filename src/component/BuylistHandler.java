package component;

import java.util.LinkedHashMap;
import java.util.Map;

public class BuylistHandler {

    // Deals with handling the orders
    // Lagra som en Map

   Map<BuylistComponent, BuylistExpandedComponent> savedShoppingMap = new LinkedHashMap<>();
//
//
//
    public void addTestEntries(){
        savedShoppingMap.put(configureBuyListComponent(new BuylistComponent()), new BuylistExpandedComponent());
        savedShoppingMap.put(configureBuyListComponent(new BuylistComponent()), new BuylistExpandedComponent());
        savedShoppingMap.put(configureBuyListComponent(new BuylistComponent()), new BuylistExpandedComponent());
    }

    public Map<BuylistComponent, BuylistExpandedComponent> getSavedShoppingMap() {
        return savedShoppingMap;
    }

    public BuylistComponent configureBuyListComponent(BuylistComponent blComp){
        blComp.getExpandedPane().setOnMouseClicked(e -> blComp.getExpandedPane().setContent(new BuylistExpandedComponent()));
        return blComp;
    }


}
