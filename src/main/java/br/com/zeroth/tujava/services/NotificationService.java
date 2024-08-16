package br.com.zeroth.tujava.services;

import br.com.zeroth.tujava.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendOrderConfirmation(Order order) {
        System.out.println("sent");
    }
}
