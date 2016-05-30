package com.goit.projects.restaurant.model.dao;

import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Order;

import java.util.List;

public interface OrderDAO {

    void saveOrder(Order newOrder);

    void addDishTo(int orderId, String dishName);

    void removeDishFrom(int orderId, String dish);

    void removeOrder(int orderId);

    void closeOrder(int orderId);

    List<Dish> loadDishesByOrderId(int orderId);

    List<Order> findOpened();

    List<Order> findClosed();


}
