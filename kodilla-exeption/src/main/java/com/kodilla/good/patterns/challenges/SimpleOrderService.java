package com.kodilla.good.patterns.challenges;

public class SimpleOrderService implements OrderService {
    @Override
    public boolean order(User user, Product product) {
        System.out.println(user.getName() + " is ordering: " + product.getName());
        return true; // simulate success
    }
}
