package com.goit.projects.restaurant.model.entity;

import java.util.Date;

public class Order {
    private int order_id;
    private int waiter_id;
    private int table_number;
    private Date order_date;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(int waiter_id) {
        this.waiter_id = waiter_id;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", waiter_id=" + waiter_id +
                ", table_number=" + table_number +
                ", order_date=" + order_date +
                '}';
    }
}
