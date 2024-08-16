package br.com.zeroth.tujava.domain;

import lombok.Data;

@Data
public class Order {
    private Product product;
    private Customer customer;
    private Amount amount;
}
