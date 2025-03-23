package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Supplier {

    @Override
    public boolean process(Order order) {
        System.out.println("[ExtraFoodShop] Ordering " + order.getQuantity() + "x " + order.getProduct());
        // Simulate processing
        return order.getQuantity() < 10; // accepts small orders only
    }

    @Override
    public String getSupplierName() {
        return "ExtraFoodShop";
    }
}
