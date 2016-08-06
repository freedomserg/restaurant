package com.goit.projects.restaurant.model.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Employee {

    @OneToMany(mappedBy = "waiter", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("orders: ").append("\n");
        orders.forEach(order -> builder.append(order).append("\n"));
        return builder.toString();
    }
}
