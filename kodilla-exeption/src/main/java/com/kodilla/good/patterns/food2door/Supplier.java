package com.kodilla.good.patterns.food2door;

public interface Supplier {
    boolean process(Order order);
    String getSupplierName();
}
