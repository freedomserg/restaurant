package com.goit.projects.restaurant.model.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "dish_id")
    private int dish_id;

    @Column(name = "dish_name")
    private String dish_name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private FoodCategory category;

    @Column(name = "price")
    private double price;

    @Column(name = "weight")
    private int weight;

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        if (Double.compare(dish.price, price) != 0) return false;
        if (weight != dish.weight) return false;
        if (!dish_name.equals(dish.dish_name)) return false;
        return category.equals(dish.category);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dish_name.hashCode();
        result = 31 * result + category.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dish_id=" + dish_id +
                ", dish_name='" + dish_name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
