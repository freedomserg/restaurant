package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.OrderDAO;
import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Order;
import com.goit.projects.restaurant.model.entity.OrderState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class HOrderController {

    private OrderDAO orderDAO;
    private HEmployeeController employeeController;
    private HDishController dishController;
    public Logger logger = LoggerFactory.getLogger(HOrderController.class);

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void setEmployeeController(HEmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(HDishController dishController) {
        this.dishController = dishController;
    }

    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setWaiter(employeeController.getById(1));
        order.setTableNumber(1);
        order.setOrderDate(new Date());
        order.setState(OrderState.OPENED);

        List<Dish> dishes = Arrays.asList(
                dishController.getByName("Margarita"),
                dishController.getByName("Caesar"),
                dishController.getByName("Caesar"),
                dishController.getByName("Pork steak"),
                dishController.getByName("Pork steak")
        );
        order.setDishes(dishes);

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

    @Transactional
    public void printOrders() {
        logger.info("OPENED: ");
        getOpened().forEach(System.out::println);
        logger.info("CLOSED: ");
        getClosed().forEach(System.out::println);
    }
}
