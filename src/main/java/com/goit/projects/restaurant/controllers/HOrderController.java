package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.OrderDAO;
import com.goit.projects.restaurant.model.entity.Order;
import com.goit.projects.restaurant.model.entity.OrderState;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class HOrderController {

    private OrderDAO orderDAO;
    private HEmployeeController employeeController;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void setEmployeeController(HEmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setWaiter(employeeController.getById(1));
        order.setTableNumber(1);
        order.setOrderDate(new Date());
        order.setState(OrderState.OPENED);

        orderDAO.saveOrder(order);
    }

    @Transactional
    public List<Order> getOpened() {
        return orderDAO.findOpened();
    }

    @Transactional
    public List<Order> getClosed() {
        return orderDAO.findClosed();
    }
}
