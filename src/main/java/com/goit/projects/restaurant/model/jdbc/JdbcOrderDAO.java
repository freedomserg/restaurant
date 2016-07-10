package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.exceptions.JdbcRestaurantException;
import com.goit.projects.restaurant.model.dao.OrderDAO;
import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Order;
import com.goit.projects.restaurant.model.jdbc.rowMappers.DishRowMapper;
import com.goit.projects.restaurant.model.jdbc.rowMappers.OrderRowMapper;
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
        jdbcTemplate.update(query, newOrder.getWaiterId(), newOrder.getTableNumber(),
                new Date(newOrder.getOrderDate().getTime()));
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDishTo(int orderId, String dishName, int dishQuantity) {
        isClosed(orderId);
        String query = "INSERT INTO order_dish (order_id, dish_id, dish_quantity)" +
                            "VALUES (?, " +
                                    "(SELECT dish_id FROM dish WHERE dish_name = ?), " +
                                    "?)";
        jdbcTemplate.update(query, orderId, dishName, dishQuantity);
    }

    private void isClosed(int orderId) {
        String checkOrderStateQuery = "SELECT order_state FROM client_order WHERE order_id = ?";
        String orderState = jdbcTemplate.query(checkOrderStateQuery, resultSet -> {
            if (resultSet.next()) {
                return resultSet.getString("order_state");
            }
            throw new JdbcRestaurantException("No such order");
        }, orderId);
        if ("closed".equals(orderState)) {
            throw new JdbcRestaurantException("Couldn't change / remove closed order");
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishFrom(int orderId, String dishName) {
        isClosed(orderId);
        String query = "DELETE FROM order_dish WHERE " +
                            "order_id = ? " +
                                "AND dish_id = " +
                                    "(SELECT dish_id FROM dish WHERE dish_name = ?)";
        jdbcTemplate.update(query, orderId, dishName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void setNewDishQuantity(int orderId, String dishName, int newQuantity) {
        isClosed(orderId);
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


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void closeOrder(int orderId) {
        isClosed(orderId);
        String query = "UPDATE client_order SET order_state = 'closed' " +
                            "WHERE order_id = ?";
        jdbcTemplate.update(query, orderId);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> loadDishesByOrderId(int orderId) {
        String query = "SELECT * FROM dish " +
                            "INNER JOIN order_dish " +
                                "ON order_dish.order_id = ? " +
                                    "AND order_dish.dish_id = dish.dish_id";
        return jdbcTemplate.query(query, new DishRowMapper(), orderId);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findOpened() {
        String query = "SELECT * FROM client_order " +
                            "WHERE order_state = 'opened'";
        return jdbcTemplate.query(query, new OrderRowMapper());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findClosed() {
        String query = "SELECT * FROM client_order " +
                "WHERE order_state = 'closed'";
        return jdbcTemplate.query(query, new OrderRowMapper());
    }
}
