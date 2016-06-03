package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.exceptions.SqlRestaurantException;
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
        String query = "DELETE FROM order_dish WHERE " +
                            "order_id = ? " +
                                "AND dish_id = " +
                                    "(SELECT dish_id FROM dish WHERE dish_name = ?)";
        jdbcTemplate.update(query, orderId, dishName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void setNewDishQuantity(int orderId, String dishName, int newQuantity) {
        String query = "UPDATE order_dish SET dish_quantity = ? " +
                            "WHERE order_id = ? " +
                                "AND dish_id = " +
                                    "(SELECT dish_id FROM dish WHERE dish_name = ?)";
        jdbcTemplate.update(query, newQuantity, orderId, dishName);

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeOrder(int orderId) {
        isClosed(orderId);
        String removeFromOrderDishQuery = "DELETE FROM order_dish WHERE order_id = ?";
        jdbcTemplate.update(removeFromOrderDishQuery, orderId);
        String removeFromClientOrderQuery = "DELETE FROM client_order WHERE order_id = ?";
        jdbcTemplate.update(removeFromClientOrderQuery, orderId);
    }

    private void isClosed(int orderId) {
        String checkOrderStateQuery = "SELECT order_state FROM client_order WHERE order_id = ?";
        String orderState = jdbcTemplate.query(checkOrderStateQuery, resultSet -> {
            if (resultSet.next()) {
                return resultSet.getString("order_state");
            }
            throw new SqlRestaurantException("No such order");
        }, orderId);
        if ("closed".equals(orderState)) {
            throw new SqlRestaurantException("Couldn't delete closed order");
        }
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
