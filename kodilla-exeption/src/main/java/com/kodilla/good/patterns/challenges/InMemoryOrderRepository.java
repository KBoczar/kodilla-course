package com.kodilla.good.patterns.challenges;

public class InMemoryOrderRepository implements OrderRepository {
    @Override
    public void saveOrder(User user, Product product) {
        System.out.println("Order saved in repository: " + user.getName() + " - " + product.getName());
    }
}
