package com.goit.projects.restaurant.model.dao;

import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder(Order newOrder);

    void addDishTo(Order order, Dish dish);

    void removeDishFrom(Order order, Dish dish);

    void removeOrder(Order order);

    void closeOrder(Order order);

    List<Order> findOpened();

    List<Order> findClosed();


}
