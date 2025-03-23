package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Supplier {

    @Override
    public boolean process(Order order) {
        System.out.println("[GlutenFreeShop] Shipping gluten-free " + order.getProduct());
        return !order.getProduct().toLowerCase().contains("wheat"); // no wheat
    }

    @Override
    public String getSupplierName() {
        return "GlutenFreeShop";
    }
}
