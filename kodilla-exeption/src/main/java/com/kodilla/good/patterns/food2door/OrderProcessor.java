package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    public void processOrder(Supplier supplier, Order order) {
        System.out.println("=== Processing order with " + supplier.getSupplierName() + " ===");

        boolean success = supplier.process(order);

        if (success) {
            System.out.println("Order completed successfully!\n");
        } else {
            System.out.println("Order failed.\n");
        }
    }
}
