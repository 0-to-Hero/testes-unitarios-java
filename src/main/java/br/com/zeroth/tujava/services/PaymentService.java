package br.com.zeroth.tujava.services;

import br.com.zeroth.tujava.domain.Amount;
import br.com.zeroth.tujava.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public boolean processPayment(Customer customer, Amount amount) {
        return false;
    }
}
