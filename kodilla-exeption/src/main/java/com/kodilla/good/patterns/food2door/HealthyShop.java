package com.kodilla.good.patterns.food2door;

public class HealthyShop implements Supplier {

    @Override
    public boolean process(Order order) {
        System.out.println("[HealthyShop] Processing order: " + order.getProduct());
        return order.getProduct().toLowerCase().contains("organic"); // only organic products
    }

    @Override
    public String getSupplierName() {
        return "HealthyShop";
    }
}
