package br.com.zeroth.tujava.services;

import br.com.zeroth.tujava.domain.Order;

public class OrderProcessingService {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private NotificationService notificationService;

    public OrderProcessingService(InventoryService inventoryService,
                                  PaymentService paymentService,
                                  NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public boolean processOrder(Order order) {
        if (inventoryService.isInStock(order.getProduct())) {
            boolean paymentSuccess = paymentService.processPayment(order.getCustomer(), order.getAmount());
            if (paymentSuccess) {
                notificationService.sendOrderConfirmation(order);
                return true;
            }
        }
        return false;
    }
}
