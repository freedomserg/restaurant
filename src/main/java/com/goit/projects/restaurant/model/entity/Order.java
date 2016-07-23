package com.goit.projects.restaurant.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client_order")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private Employee waiter;

    @Column(name = "table_number")
    private int tableNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_dish",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
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

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (tableNumber != order.tableNumber) return false;
        if (!waiter.equals(order.waiter)) return false;
        if (!dishes.equals(order.dishes)) return false;
        if (!orderDate.equals(order.orderDate)) return false;
        return state == order.state;

    }

    @Override
    public int hashCode() {
        int result = waiter.hashCode();
        result = 31 * result + tableNumber;
        result = 31 * result + dishes.hashCode();
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", tableNumber=" + tableNumber +
                ", dishes=" + dishes +
                ", orderDate=" + new SimpleDateFormat("dd/MM/yyyy").format(orderDate) +
                ", state=" + state +
                '}';
    }
}
