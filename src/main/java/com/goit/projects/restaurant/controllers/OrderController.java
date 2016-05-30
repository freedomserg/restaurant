package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.OrderDAO;
import com.goit.projects.restaurant.model.entity.Order;
import com.goit.projects.restaurant.model.jdbc.JdbcOrderDAO;
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
}
