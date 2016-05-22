package com.goit.projects.restaurant.model;

import java.util.Date;

public class CookedDish {
    private int cookedDish_id;
    private int dish_id;
    private int cook_id;
    private int order_id;
    private Date preparation_date;

    public int getCookedDish_id() {
        return cookedDish_id;
    }

    public void setCookedDish_id(int cookedDish_id) {
        this.cookedDish_id = cookedDish_id;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getCook_id() {
        return cook_id;
    }

    public void setCook_id(int cook_id) {
        this.cook_id = cook_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getPreparation_date() {
        return preparation_date;
    }

    public void setPreparation_date(Date preparation_date) {
        this.preparation_date = preparation_date;
    }

    @Override
    public String toString() {
        return "CookedDish{" +
                "cookedDish_id=" + cookedDish_id +
                ", dish_id=" + dish_id +
                ", cook_id=" + cook_id +
                ", order_id=" + order_id +
                ", preparation_date=" + preparation_date +
                '}';
    }
}
