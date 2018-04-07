package ru.tinkoff.entities;

import java.util.List;

public class Account {
    private Long id;
    private String customerName;
    private List<Order> orders;

    public Account() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
