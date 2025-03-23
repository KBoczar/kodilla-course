package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        Supplier extraFoodShop = new ExtraFoodShop();
        Supplier healthyShop = new HealthyShop();
        Supplier glutenFreeShop = new GlutenFreeShop();

        Order order1 = new Order("Carrot", 5);
        Order order2 = new Order("Organic apples", 10);
        Order order3 = new Order("Wheat bread", 3);

        processor.processOrder(extraFoodShop, order1);     // true
        processor.processOrder(healthyShop, order2);       // true
        processor.processOrder(glutenFreeShop, order3);    // false (contains wheat)
    }
}
