package com.goit.projects.restaurant.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "client_order")
public class Order {

    //@Id
    //@GeneratedValue(generator = "increment")
    //@GenericGenerator(name = "increment", strategy = "increment")
    //@Column(name = "order_id")
    private int orderId;

    //@ManyToOne
    //@JoinColumn(name = "employee_id")
    //@Column(name = "waiter_id")
    private int waiterId;

    //@Column(name = "table_number")
    private int tableNumber;

    //@Column(name = "order_date")
    private Date orderDate;

    //@Column(name = "order_state")
    private String state;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", waiterId=" + waiterId +
                ", tableNumber=" + tableNumber +
                ", orderDate=" + orderDate +
                ", state='" + state + '\'' +
                '}';
    }
}
