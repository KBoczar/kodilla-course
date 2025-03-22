package com.kodilla.good.patterns.challenges;

public class ProductOrderApp {
    public static void main(String[] args) {
        User user = new User("Ashen One");
        Product product = new Product("Firelink Slippers");

        OrderRequest orderRequest = new OrderRequest(user, product);

        ProductOrderService orderProcessor = new ProductOrderService(
                new EmailInformationService(),
                new SimpleOrderService(),
                new InMemoryOrderRepository()
        );

        OrderDto orderDto = orderProcessor.process(orderRequest);

        if (orderDto.isOrdered()) {
            System.out.println("Order successfully processed.");
        } else {
            System.out.println("Order failed.");
        }
    }
}
