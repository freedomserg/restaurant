package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.dao.OrderDAO;
import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public class JdbcOrderDAO implements OrderDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveOrder(Order newOrder) {
        String query = "INSERT INTO client_order (waiter_id, table_number, order_date," +
                "order_state) VALUES (?, ?, ?, 'opened')";
        jdbcTemplate.update(query, newOrder.getWaiter_id(), newOrder.getTable_number(),
                new Date(newOrder.getOrder_date().getTime()));
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDishTo(int orderId, String dishName, int dishQuantity) {
        String query = "INSERT INTO order_dish (order_id, dish_id, dish_quantity)" +
                            "VALUES (?, " +
                                    "(SELECT dish_id FROM dish WHERE dish_name = ?), " +
                                    "?)";
        jdbcTemplate.update(query, orderId, dishName, dishQuantity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishFrom(int orderId, String dishName) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void setNewDishQuantity(int orderId, String dishName, int newQuantity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeOrder(int orderId) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void closeOrder(int orderId) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> loadDishesByOrderId(int orderId) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findOpened() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findClosed() {
        return null;
    }
}
