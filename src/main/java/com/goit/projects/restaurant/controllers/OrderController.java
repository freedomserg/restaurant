package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.OrderDAO;
import com.goit.projects.restaurant.model.entity.Order;
import org.springframework.transaction.annotation.Transactional;

public class OrderController {

    private OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Transactional
    public void addOrder(Order newOrder) {
        orderDAO.saveOrder(newOrder);
    }

    @Transactional
    public void putDishTo(int orderId, String dishName, int dishQuantity) {
        orderDAO.addDishTo(orderId, dishName, dishQuantity);
    }

    @Transactional
    public void deleteDishFrom(int orderId, String dishName) {
        orderDAO.removeDishFrom(orderId, dishName);
    }

    @Transactional
    public void updateDishQuantity(int orderId, String dishName, int newQuantity) {
        orderDAO.setNewDishQuantity(orderId, dishName, newQuantity);
    }

    @Transactional
    public void deleteOrder(int orderId) {
        orderDAO.removeOrder(orderId);
    }


}
